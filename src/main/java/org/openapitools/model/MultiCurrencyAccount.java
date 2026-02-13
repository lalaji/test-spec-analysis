package org.openapitools.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents a multi-currency account with IBAN-based identification
 */
@Schema(description = "Represents a multi-currency account with IBAN-based identification")
public class MultiCurrencyAccount {

    @JsonProperty("iban")
    private String iban;

    @JsonProperty("accountName")
    private String accountName;

    @JsonProperty("accountOwner")
    private String accountOwner;

    @JsonProperty("subAccounts")
    private List<SubAccount> subAccounts = new ArrayList<>();

    @JsonProperty("createdAt")
    private OffsetDateTime createdAt;

    public MultiCurrencyAccount iban(String iban) {
        this.iban = iban;
        return this;
    }

    @Schema(description = "International Bank Account Number (IBAN) uniquely identifying the account", example = "DE89370400440532013000", required = true)
    @NotNull
    @Pattern(regexp = "^[A-Z]{2}[0-9]{2}[A-Z0-9]+$")
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public MultiCurrencyAccount accountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    @Schema(description = "Name or description of the multi-currency account", example = "Corporate Multi-Currency Account", required = true)
    @NotNull
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public MultiCurrencyAccount accountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
        return this;
    }

    @Schema(description = "Owner of the account", example = "John Doe")
    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public MultiCurrencyAccount subAccounts(List<SubAccount> subAccounts) {
        this.subAccounts = subAccounts;
        return this;
    }

    public MultiCurrencyAccount addSubAccountsItem(SubAccount subAccountsItem) {
        this.subAccounts.add(subAccountsItem);
        return this;
    }

    @Schema(description = "Currency-specific sub-accounts. Each IBAN + currency combination uniquely identifies a sub-account per REQ_0423", required = true)
    @NotNull
    @Valid
    public List<SubAccount> getSubAccounts() {
        return subAccounts;
    }

    public void setSubAccounts(List<SubAccount> subAccounts) {
        this.subAccounts = subAccounts;
    }

    public MultiCurrencyAccount createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @Schema(description = "Timestamp when the account was created", example = "2024-01-15T10:30:00Z")
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiCurrencyAccount that = (MultiCurrencyAccount) o;
        return Objects.equals(iban, that.iban) &&
               Objects.equals(accountName, that.accountName) &&
               Objects.equals(accountOwner, that.accountOwner) &&
               Objects.equals(subAccounts, that.subAccounts) &&
               Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, accountName, accountOwner, subAccounts, createdAt);
    }

    @Override
    public String toString() {
        return "MultiCurrencyAccount{" +
               "iban='" + iban + '\'' +
               ", accountName='" + accountName + '\'' +
               ", accountOwner='" + accountOwner + '\'' +
               ", subAccounts=" + subAccounts +
               ", createdAt=" + createdAt +
               '}';
    }
}
