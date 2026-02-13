package org.openapitools.model;

import java.time.OffsetDateTime;
import java.util.Objects;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Currency-specific sub-account of a multi-currency account. An IBAN together with a currency uniquely addresses this sub-account (REQ_0423)
 */
@Schema(description = "Currency-specific sub-account of a multi-currency account. An IBAN together with a currency uniquely addresses this sub-account (REQ_0423)")
public class SubAccount {

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("balance")
    private Double balance;

    /**
     * Status of the sub-account
     */
    public enum StatusEnum {
        ACTIVE("ACTIVE"),
        INACTIVE("INACTIVE"),
        CLOSED("CLOSED");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static StatusEnum fromValue(String value) {
            for (StatusEnum b : StatusEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("status")
    private StatusEnum status;

    @JsonProperty("accountId")
    private String accountId;

    @JsonProperty("lastTransactionDate")
    private OffsetDateTime lastTransactionDate;

    public SubAccount currency(String currency) {
        this.currency = currency;
        return this;
    }

    @Schema(description = "ISO 4217 currency code for this sub-account", example = "EUR", required = true)
    @NotNull
    @Pattern(regexp = "^[A-Z]{3}$")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public SubAccount balance(Double balance) {
        this.balance = balance;
        return this;
    }

    @Schema(description = "Current balance in the sub-account", example = "1250.5", required = true)
    @NotNull
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public SubAccount status(StatusEnum status) {
        this.status = status;
        return this;
    }

    @Schema(description = "Status of the sub-account", example = "ACTIVE", required = true)
    @NotNull
    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public SubAccount accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    @Schema(description = "Internal identifier for this sub-account (IBAN + currency combination)", example = "DE89370400440532013000-EUR")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public SubAccount lastTransactionDate(OffsetDateTime lastTransactionDate) {
        this.lastTransactionDate = lastTransactionDate;
        return this;
    }

    @Schema(description = "Date of the last transaction", example = "2024-01-15T10:30:00Z")
    public OffsetDateTime getLastTransactionDate() {
        return lastTransactionDate;
    }

    public void setLastTransactionDate(OffsetDateTime lastTransactionDate) {
        this.lastTransactionDate = lastTransactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubAccount that = (SubAccount) o;
        return Objects.equals(currency, that.currency) &&
               Objects.equals(balance, that.balance) &&
               Objects.equals(status, that.status) &&
               Objects.equals(accountId, that.accountId) &&
               Objects.equals(lastTransactionDate, that.lastTransactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, balance, status, accountId, lastTransactionDate);
    }

    @Override
    public String toString() {
        return "SubAccount{" +
               "currency='" + currency + '\'' +
               ", balance=" + balance +
               ", status=" + status +
               ", accountId='" + accountId + '\'' +
               ", lastTransactionDate=" + lastTransactionDate +
               '}';
    }
}
