package org.openapitools.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapitools.model.MultiCurrencyAccount;
import org.openapitools.model.RegisterMultiCurrencyAccountRequest;
import org.openapitools.model.SubAccount;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for MultiCurrencyAccountService implementation.
 * Tests Berlin Group REQ_0423 compliance: IBAN + currency uniquely identifies sub-accounts.
 */
class MultiCurrencyAccountServiceImplTest {

    private MultiCurrencyAccountService service;

    @BeforeEach
    void setUp() {
        service = new MultiCurrencyAccountServiceImpl();
    }

    @Test
    void testRegisterMultiCurrencyAccount_Success() {
        // Arrange
        RegisterMultiCurrencyAccountRequest request = new RegisterMultiCurrencyAccountRequest();
        request.setRequestId("TEST123");
        request.setIban("DE89370400440532013000");
        request.setAccountName("Test Multi-Currency Account");
        request.setAccountOwner("John Doe");
        request.setSupportedCurrencies(Arrays.asList("EUR", "USD", "GBP"));

        // Act
        MultiCurrencyAccount account = service.registerMultiCurrencyAccount(request);

        // Assert
        assertNotNull(account);
        assertEquals("DE89370400440532013000", account.getIban());
        assertEquals("Test Multi-Currency Account", account.getAccountName());
        assertEquals("John Doe", account.getAccountOwner());
        assertNotNull(account.getCreatedAt());
        assertEquals(3, account.getSubAccounts().size());

        // Verify sub-accounts are created for each currency
        List<String> currencies = Arrays.asList("EUR", "USD", "GBP");
        for (String currency : currencies) {
            assertTrue(account.getSubAccounts().stream()
                    .anyMatch(sub -> sub.getCurrency().equals(currency)));
        }
    }

    @Test
    void testRegisterMultiCurrencyAccount_InvalidIban() {
        // Arrange
        RegisterMultiCurrencyAccountRequest request = new RegisterMultiCurrencyAccountRequest();
        request.setRequestId("TEST123");
        request.setIban("INVALID_IBAN");
        request.setAccountName("Test Account");
        request.setSupportedCurrencies(Arrays.asList("EUR"));

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> 
            service.registerMultiCurrencyAccount(request));
    }

    @Test
    void testRegisterMultiCurrencyAccount_DuplicateIban() {
        // Arrange
        RegisterMultiCurrencyAccountRequest request1 = new RegisterMultiCurrencyAccountRequest();
        request1.setRequestId("TEST123");
        request1.setIban("DE89370400440532013000");
        request1.setAccountName("Account 1");
        request1.setSupportedCurrencies(Arrays.asList("EUR"));

        RegisterMultiCurrencyAccountRequest request2 = new RegisterMultiCurrencyAccountRequest();
        request2.setRequestId("TEST124");
        request2.setIban("DE89370400440532013000");
        request2.setAccountName("Account 2");
        request2.setSupportedCurrencies(Arrays.asList("USD"));

        // Act
        service.registerMultiCurrencyAccount(request1);

        // Assert
        assertThrows(IllegalArgumentException.class, () -> 
            service.registerMultiCurrencyAccount(request2));
    }

    @Test
    void testRegisterMultiCurrencyAccount_InvalidCurrency() {
        // Arrange
        RegisterMultiCurrencyAccountRequest request = new RegisterMultiCurrencyAccountRequest();
        request.setRequestId("TEST123");
        request.setIban("DE89370400440532013000");
        request.setAccountName("Test Account");
        request.setSupportedCurrencies(Arrays.asList("INVALID"));

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> 
            service.registerMultiCurrencyAccount(request));
    }

    /**
     * Test REQ_0423: IBAN + currency uniquely identifies a sub-account
     */
    @Test
    void testGetSubAccountByIbanAndCurrency_REQ_0423_Compliance() {
        // Arrange - Create a multi-currency account
        RegisterMultiCurrencyAccountRequest request = new RegisterMultiCurrencyAccountRequest();
        request.setRequestId("TEST123");
        request.setIban("DE89370400440532013000");
        request.setAccountName("Test Multi-Currency Account");
        request.setSupportedCurrencies(Arrays.asList("EUR", "USD", "GBP"));
        service.registerMultiCurrencyAccount(request);

        // Act - Retrieve EUR sub-account
        Optional<SubAccount> eurSubAccount = service.getSubAccountByIbanAndCurrency(
                "DE89370400440532013000", "EUR");

        // Assert - EUR sub-account should be found and unique
        assertTrue(eurSubAccount.isPresent());
        assertEquals("EUR", eurSubAccount.get().getCurrency());
        assertEquals("DE89370400440532013000-EUR", eurSubAccount.get().getAccountId());
        assertEquals(SubAccount.StatusEnum.ACTIVE, eurSubAccount.get().getStatus());
        assertEquals(0.0, eurSubAccount.get().getBalance());

        // Act - Retrieve USD sub-account
        Optional<SubAccount> usdSubAccount = service.getSubAccountByIbanAndCurrency(
                "DE89370400440532013000", "USD");

        // Assert - USD sub-account should be found and unique
        assertTrue(usdSubAccount.isPresent());
        assertEquals("USD", usdSubAccount.get().getCurrency());
        assertEquals("DE89370400440532013000-USD", usdSubAccount.get().getAccountId());

        // Verify that different currencies yield different sub-accounts
        assertNotEquals(eurSubAccount.get().getAccountId(), usdSubAccount.get().getAccountId());
    }

    @Test
    void testGetSubAccountByIbanAndCurrency_NotFound() {
        // Arrange - Create an account with EUR and USD
        RegisterMultiCurrencyAccountRequest request = new RegisterMultiCurrencyAccountRequest();
        request.setRequestId("TEST123");
        request.setIban("DE89370400440532013000");
        request.setAccountName("Test Account");
        request.setSupportedCurrencies(Arrays.asList("EUR", "USD"));
        service.registerMultiCurrencyAccount(request);

        // Act - Try to get GBP sub-account (not supported)
        Optional<SubAccount> subAccount = service.getSubAccountByIbanAndCurrency(
                "DE89370400440532013000", "GBP");

        // Assert
        assertFalse(subAccount.isPresent());
    }

    @Test
    void testGetSubAccountByIbanAndCurrency_IbanNotFound() {
        // Act
        Optional<SubAccount> subAccount = service.getSubAccountByIbanAndCurrency(
                "DE89370400440532013999", "EUR");

        // Assert
        assertFalse(subAccount.isPresent());
    }

    @Test
    void testGetSubAccountByIbanAndCurrency_InvalidIban() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> 
            service.getSubAccountByIbanAndCurrency("INVALID", "EUR"));
    }

    @Test
    void testGetSubAccountByIbanAndCurrency_InvalidCurrency() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> 
            service.getSubAccountByIbanAndCurrency("DE89370400440532013000", "INVALID"));
    }

    @Test
    void testGetMultiCurrencyAccountByIban_Success() {
        // Arrange
        RegisterMultiCurrencyAccountRequest request = new RegisterMultiCurrencyAccountRequest();
        request.setRequestId("TEST123");
        request.setIban("DE89370400440532013000");
        request.setAccountName("Test Account");
        request.setSupportedCurrencies(Arrays.asList("EUR", "USD"));
        service.registerMultiCurrencyAccount(request);

        // Act
        Optional<MultiCurrencyAccount> account = service.getMultiCurrencyAccountByIban(
                "DE89370400440532013000");

        // Assert
        assertTrue(account.isPresent());
        assertEquals("DE89370400440532013000", account.get().getIban());
        assertEquals("Test Account", account.get().getAccountName());
    }

    @Test
    void testGetMultiCurrencyAccountByIban_NotFound() {
        // Act
        Optional<MultiCurrencyAccount> account = service.getMultiCurrencyAccountByIban(
                "DE89370400440532013999");

        // Assert
        assertFalse(account.isPresent());
    }

    @Test
    void testIsValidIban_Valid() {
        assertTrue(service.isValidIban("DE89370400440532013000"));
        assertTrue(service.isValidIban("GB82WEST12345698765432"));
        assertTrue(service.isValidIban("FR1420041010050500013M02606"));
    }

    @Test
    void testIsValidIban_Invalid() {
        assertFalse(service.isValidIban("INVALID"));
        assertFalse(service.isValidIban("DE8937040044")); // Too short
        assertFalse(service.isValidIban("de89370400440532013000")); // Lowercase
        assertFalse(service.isValidIban("89370400440532013000")); // Missing country code
        assertFalse(service.isValidIban(null));
    }

    @Test
    void testIsValidCurrency_Valid() {
        assertTrue(service.isValidCurrency("EUR"));
        assertTrue(service.isValidCurrency("USD"));
        assertTrue(service.isValidCurrency("GBP"));
        assertTrue(service.isValidCurrency("JPY"));
    }

    @Test
    void testIsValidCurrency_Invalid() {
        assertFalse(service.isValidCurrency("eur")); // Lowercase
        assertFalse(service.isValidCurrency("US")); // Too short
        assertFalse(service.isValidCurrency("USDD")); // Too long
        assertFalse(service.isValidCurrency("123")); // Numbers
        assertFalse(service.isValidCurrency(null));
    }

    /**
     * Integration test verifying complete REQ_0423 flow:
     * 1. Register multi-currency account
     * 2. Verify IBAN + currency combination uniquely identifies sub-accounts
     */
    @Test
    void testREQ_0423_FullFlow() {
        // Step 1: Register multi-currency account with 3 currencies
        RegisterMultiCurrencyAccountRequest request = new RegisterMultiCurrencyAccountRequest();
        request.setRequestId("REQ_0423_TEST");
        request.setIban("FR1420041010050500013M02606");
        request.setAccountName("International Business Account");
        request.setAccountOwner("ACME Corporation");
        request.setSupportedCurrencies(Arrays.asList("EUR", "USD", "GBP"));

        MultiCurrencyAccount account = service.registerMultiCurrencyAccount(request);

        // Step 2: Verify each IBAN + currency combination is unique
        Optional<SubAccount> eurSub = service.getSubAccountByIbanAndCurrency(
                "FR1420041010050500013M02606", "EUR");
        Optional<SubAccount> usdSub = service.getSubAccountByIbanAndCurrency(
                "FR1420041010050500013M02606", "USD");
        Optional<SubAccount> gbpSub = service.getSubAccountByIbanAndCurrency(
                "FR1420041010050500013M02606", "GBP");

        // All sub-accounts should exist
        assertTrue(eurSub.isPresent(), "EUR sub-account should exist");
        assertTrue(usdSub.isPresent(), "USD sub-account should exist");
        assertTrue(gbpSub.isPresent(), "GBP sub-account should exist");

        // Each should have unique account ID (IBAN + currency)
        assertEquals("FR1420041010050500013M02606-EUR", eurSub.get().getAccountId());
        assertEquals("FR1420041010050500013M02606-USD", usdSub.get().getAccountId());
        assertEquals("FR1420041010050500013M02606-GBP", gbpSub.get().getAccountId());

        // All should be active with zero balance
        assertEquals(SubAccount.StatusEnum.ACTIVE, eurSub.get().getStatus());
        assertEquals(SubAccount.StatusEnum.ACTIVE, usdSub.get().getStatus());
        assertEquals(SubAccount.StatusEnum.ACTIVE, gbpSub.get().getStatus());

        assertEquals(0.0, eurSub.get().getBalance());
        assertEquals(0.0, usdSub.get().getBalance());
        assertEquals(0.0, gbpSub.get().getBalance());

        // Verify unsupported currency returns empty
        Optional<SubAccount> jpySub = service.getSubAccountByIbanAndCurrency(
                "FR1420041010050500013M02606", "JPY");
        assertFalse(jpySub.isPresent(), "JPY sub-account should not exist");
    }
}
