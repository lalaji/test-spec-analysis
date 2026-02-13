package org.openapitools.service;

import org.openapitools.model.MultiCurrencyAccount;
import org.openapitools.model.RegisterMultiCurrencyAccountRequest;
import org.openapitools.model.SubAccount;

import java.util.Optional;

/**
 * Service interface for managing multi-currency accounts with IBAN-based identification.
 * Implements Berlin Group specification requirement REQ_0423:
 * "An account identifier like an IBAN together with a currency always addresses uniquely a sub-account of a multicurrency account."
 */
public interface MultiCurrencyAccountService {

    /**
     * Registers a new multi-currency account with IBAN-based identification.
     * Creates sub-accounts for each supported currency.
     *
     * @param request The registration request containing IBAN, account name, and supported currencies
     * @return The created multi-currency account with all sub-accounts
     * @throws IllegalArgumentException if IBAN is invalid or already exists
     */
    MultiCurrencyAccount registerMultiCurrencyAccount(RegisterMultiCurrencyAccountRequest request);

    /**
     * Retrieves a specific sub-account uniquely identified by IBAN and currency combination.
     * This implements the core requirement of REQ_0423 where IBAN + currency uniquely identifies a sub-account.
     *
     * @param iban The IBAN of the multi-currency account
     * @param currency The ISO 4217 currency code
     * @return Optional containing the sub-account if found, empty otherwise
     * @throws IllegalArgumentException if IBAN or currency format is invalid
     */
    Optional<SubAccount> getSubAccountByIbanAndCurrency(String iban, String currency);

    /**
     * Retrieves a multi-currency account by IBAN.
     *
     * @param iban The IBAN of the account
     * @return Optional containing the account if found, empty otherwise
     */
    Optional<MultiCurrencyAccount> getMultiCurrencyAccountByIban(String iban);

    /**
     * Validates IBAN format according to ISO 13616 standard.
     *
     * @param iban The IBAN to validate
     * @return true if valid, false otherwise
     */
    boolean isValidIban(String iban);

    /**
     * Validates currency code format according to ISO 4217 standard.
     *
     * @param currency The currency code to validate
     * @return true if valid, false otherwise
     */
    boolean isValidCurrency(String currency);
}
