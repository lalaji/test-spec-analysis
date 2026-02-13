package org.openapitools.model;

import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Request to register a multi-currency account with IBAN-based identification
 */
@Schema(description = "Request to register a multi-currency account with IBAN-based identification")
public class RegisterMultiCurrencyAccountRequest {

    @JsonProperty("requestId")
    private String requestId;

    @JsonProperty("iban")
    private String iban;

    @JsonProperty("accountName")
    private String accountName;

    @JsonProperty("supportedCurrencies")
    private List<String> supportedCurrencies;

    @JsonProperty("accountOwner")
    private String accountOwner;

    public RegisterMultiCurrencyAccountRequest requestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    @Schema(description = "A unique correlation identifier", example = "Ec1wMjmiG8", required = true)
    @NotNull
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public RegisterMultiCurrencyAccountRequest iban(String iban) {
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

    public RegisterMultiCurrencyAccountRequest accountName(String accountName) {
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

    public RegisterMultiCurrencyAccountRequest supportedCurrencies(List<String> supportedCurrencies) {
        this.supportedCurrencies = supportedCurrencies;
        return this;
    }

    @Schema(description = "List of currencies supported by this multi-currency account", required = true)
    @NotNull
    @Size(min = 1)
    @Valid
    public List<String> getSupportedCurrencies() {
        return supportedCurrencies;
    }

    public void setSupportedCurrencies(List<String> supportedCurrencies) {
        this.supportedCurrencies = supportedCurrencies;
    }

    public RegisterMultiCurrencyAccountRequest accountOwner(String accountOwner) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterMultiCurrencyAccountRequest that = (RegisterMultiCurrencyAccountRequest) o;
        return Objects.equals(requestId, that.requestId) &&
               Objects.equals(iban, that.iban) &&
               Objects.equals(accountName, that.accountName) &&
               Objects.equals(supportedCurrencies, that.supportedCurrencies) &&
               Objects.equals(accountOwner, that.accountOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, iban, accountName, supportedCurrencies, accountOwner);
    }

    @Override
    public String toString() {
        return "RegisterMultiCurrencyAccountRequest{" +
               "requestId='" + requestId + '\'' +
               ", iban='" + iban + '\'' +
               ", accountName='" + accountName + '\'' +
               ", supportedCurrencies=" + supportedCurrencies +
               ", accountOwner='" + accountOwner + '\'' +
               '}';
    }
}
