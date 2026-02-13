package org.openapitools.model;

import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Response containing sub-account details retrieved by IBAN and currency
 */
@Schema(description = "Response containing sub-account details retrieved by IBAN and currency")
public class SubAccountResponse {

    @JsonProperty("iban")
    private String iban;

    @JsonProperty("subAccount")
    private SubAccount subAccount;

    @JsonProperty("accountName")
    private String accountName;

    public SubAccountResponse iban(String iban) {
        this.iban = iban;
        return this;
    }

    @Schema(description = "The IBAN of the multi-currency account", example = "DE89370400440532013000", required = true)
    @NotNull
    @Pattern(regexp = "^[A-Z]{2}[0-9]{2}[A-Z0-9]+$")
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public SubAccountResponse subAccount(SubAccount subAccount) {
        this.subAccount = subAccount;
        return this;
    }

    @Schema(required = true)
    @NotNull
    @Valid
    public SubAccount getSubAccount() {
        return subAccount;
    }

    public void setSubAccount(SubAccount subAccount) {
        this.subAccount = subAccount;
    }

    public SubAccountResponse accountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    @Schema(description = "Name of the parent multi-currency account", example = "Corporate Multi-Currency Account")
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubAccountResponse that = (SubAccountResponse) o;
        return Objects.equals(iban, that.iban) &&
               Objects.equals(subAccount, that.subAccount) &&
               Objects.equals(accountName, that.accountName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, subAccount, accountName);
    }

    @Override
    public String toString() {
        return "SubAccountResponse{" +
               "iban='" + iban + '\'' +
               ", subAccount=" + subAccount +
               ", accountName='" + accountName + '\'' +
               '}';
    }
}
