package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Standard error response model
 */
@Schema(description = "Standard error response model")
public class ErrorResponse {

    @JsonProperty("responseId")
    private String responseId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("errorMessage")
    private String errorMessage;

    @JsonProperty("errorDescription")
    private String errorDescription;

    @JsonProperty("errorCode")
    private Integer errorCode;

    public ErrorResponse responseId(String responseId) {
        this.responseId = responseId;
        return this;
    }

    @Schema(description = "Correlation identifier")
    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    public ErrorResponse status(String status) {
        this.status = status;
        return this;
    }

    @Schema(description = "Status of the response")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ErrorResponse errorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    @Schema(description = "Error message")
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorResponse errorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
        return this;
    }

    @Schema(description = "Detailed error description")
    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public ErrorResponse errorCode(Integer errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    @Schema(description = "Error code")
    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorResponse that = (ErrorResponse) o;
        return Objects.equals(responseId, that.responseId) &&
               Objects.equals(status, that.status) &&
               Objects.equals(errorMessage, that.errorMessage) &&
               Objects.equals(errorDescription, that.errorDescription) &&
               Objects.equals(errorCode, that.errorCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(responseId, status, errorMessage, errorDescription, errorCode);
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
               "responseId='" + responseId + '\'' +
               ", status='" + status + '\'' +
               ", errorMessage='" + errorMessage + '\'' +
               ", errorDescription='" + errorDescription + '\'' +
               ", errorCode=" + errorCode +
               '}';
    }
}
