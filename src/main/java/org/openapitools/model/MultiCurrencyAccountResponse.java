package org.openapitools.model;

import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Response after successfully registering a multi-currency account
 */
@Schema(description = "Response after successfully registering a multi-currency account")
public class MultiCurrencyAccountResponse {

    @JsonProperty("responseId")
    private String responseId;

    /**
     * Status of the operation
     */
    public enum StatusEnum {
        SUCCESS("SUCCESS"),
        ERROR("ERROR");

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

    @JsonProperty("multiCurrencyAccount")
    private MultiCurrencyAccount multiCurrencyAccount;

    public MultiCurrencyAccountResponse responseId(String responseId) {
        this.responseId = responseId;
        return this;
    }

    @Schema(description = "Correlation identifier matching the request", example = "Ec1wMjmiG8", required = true)
    @NotNull
    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    public MultiCurrencyAccountResponse status(StatusEnum status) {
        this.status = status;
        return this;
    }

    @Schema(description = "Status of the operation", example = "SUCCESS", required = true)
    @NotNull
    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public MultiCurrencyAccountResponse multiCurrencyAccount(MultiCurrencyAccount multiCurrencyAccount) {
        this.multiCurrencyAccount = multiCurrencyAccount;
        return this;
    }

    @Schema(required = true)
    @NotNull
    @Valid
    public MultiCurrencyAccount getMultiCurrencyAccount() {
        return multiCurrencyAccount;
    }

    public void setMultiCurrencyAccount(MultiCurrencyAccount multiCurrencyAccount) {
        this.multiCurrencyAccount = multiCurrencyAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiCurrencyAccountResponse that = (MultiCurrencyAccountResponse) o;
        return Objects.equals(responseId, that.responseId) &&
               Objects.equals(status, that.status) &&
               Objects.equals(multiCurrencyAccount, that.multiCurrencyAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(responseId, status, multiCurrencyAccount);
    }

    @Override
    public String toString() {
        return "MultiCurrencyAccountResponse{" +
               "responseId='" + responseId + '\'' +
               ", status=" + status +
               ", multiCurrencyAccount=" + multiCurrencyAccount +
               '}';
    }
}
