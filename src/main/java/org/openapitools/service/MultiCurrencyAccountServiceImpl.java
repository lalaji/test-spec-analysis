package org.openapitools.service;

import org.openapitools.model.MultiCurrencyAccount;
import org.openapitools.model.RegisterMultiCurrencyAccountRequest;
import org.openapitools.model.SubAccount;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/**
 * Implementation of MultiCurrencyAccountService.
 * Provides in-memory storage and management of multi-currency accounts.
 * 
 * Berlin Group REQ_0423 Compliance:
 * This implementation ensures that an IBAN together with a currency always addresses 
 * uniquely a sub-account of a multicurrency account.
 */
@Service
public class MultiCurrencyAccountServiceImpl implements MultiCurrencyAccountService {

    // In-memory storage for multi-currency accounts indexed by IBAN
    private final Map<String, MultiCurrencyAccount> accountStore = new ConcurrentHashMap<>();

    // IBAN pattern: 2 letter country code + 2 digit check + alphanumeric
    private static final Pattern IBAN_PATTERN = Pattern.compile("^[A-Z]{2}[0-9]{2}[A-Z0-9]+$");
    
    // ISO 4217 currency code pattern: 3 uppercase letters
    private static final Pattern CURRENCY_PATTERN = Pattern.compile("^[A-Z]{3}$");

    @Override
    public MultiCurrencyAccount registerMultiCurrencyAccount(RegisterMultiCurrencyAccountRequest request) {
        // Validate IBAN format
        if (!isValidIban(request.getIban())) {
            throw new IllegalArgumentException("Invalid IBAN format: " + request.getIban());
        }

        // Check if IBAN already exists
        if (accountStore.containsKey(request.getIban())) {
            throw new IllegalArgumentException("Account with IBAN " + request.getIban() + " already exists");
        }

        // Validate all currency codes
        for (String currency : request.getSupportedCurrencies()) {
            if (!isValidCurrency(currency)) {
                throw new IllegalArgumentException("Invalid currency code: " + currency);
            }
        }

        // Create the multi-currency account
        MultiCurrencyAccount account = new MultiCurrencyAccount();
        account.setIban(request.getIban());
        account.setAccountName(request.getAccountName());
        account.setAccountOwner(request.getAccountOwner());
        account.setCreatedAt(OffsetDateTime.now());

        // Create sub-accounts for each supported currency
        List<SubAccount> subAccounts = new ArrayList<>();
        for (String currency : request.getSupportedCurrencies()) {
            SubAccount subAccount = new SubAccount();
            subAccount.setCurrency(currency);
            subAccount.setBalance(0.0); // Initial balance is 0
            subAccount.setStatus(SubAccount.StatusEnum.ACTIVE);
            // Generate unique account ID: IBAN + currency combination (REQ_0423)
            subAccount.setAccountId(request.getIban() + "-" + currency);
            subAccount.setLastTransactionDate(null); // No transactions yet
            subAccounts.add(subAccount);
        }
        account.setSubAccounts(subAccounts);

        // Store the account
        accountStore.put(request.getIban(), account);

        return account;
    }

    @Override
    public Optional<SubAccount> getSubAccountByIbanAndCurrency(String iban, String currency) {
        // Validate IBAN and currency formats
        if (!isValidIban(iban)) {
            throw new IllegalArgumentException("Invalid IBAN format: " + iban);
        }
        if (!isValidCurrency(currency)) {
            throw new IllegalArgumentException("Invalid currency code: " + currency);
        }

        // Get the multi-currency account
        MultiCurrencyAccount account = accountStore.get(iban);
        if (account == null) {
            return Optional.empty();
        }

        // Find the sub-account with the matching currency
        // This implements REQ_0423: IBAN + currency uniquely identifies a sub-account
        return account.getSubAccounts().stream()
                .filter(subAccount -> subAccount.getCurrency().equals(currency))
                .findFirst();
    }

    @Override
    public Optional<MultiCurrencyAccount> getMultiCurrencyAccountByIban(String iban) {
        if (!isValidIban(iban)) {
            throw new IllegalArgumentException("Invalid IBAN format: " + iban);
        }
        return Optional.ofNullable(accountStore.get(iban));
    }

    @Override
    public boolean isValidIban(String iban) {
        return iban != null && IBAN_PATTERN.matcher(iban).matches();
    }

    @Override
    public boolean isValidCurrency(String currency) {
        return currency != null && CURRENCY_PATTERN.matcher(currency).matches();
    }
}
