package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Response for payment cancellation authorization update
 */
@Schema(name = "Response200ForPaymentCancellationAuthorization", description = "Response for payment cancellation authorization update")
public class Response200ForPaymentCancellationAuthorization {

  /**
   * Indicates the outcome of the request
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

  @JsonProperty("responseId")
  private String responseId;

  @JsonProperty("status")
  private StatusEnum status;

  @JsonProperty("data")
  private PaymentCancellationAuthorizationResponseData data;

  @JsonProperty("errorCode")
  private Integer errorCode;

  @JsonProperty("errorMessage")
  private String errorMessage;

  public Response200ForPaymentCancellationAuthorization responseId(String responseId) {
    this.responseId = responseId;
    return this;
  }

  /**
   * Unique response identifier
   * @return responseId
  */
  @NotNull 
  @Schema(name = "responseId", description = "Unique response identifier", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getResponseId() {
    return responseId;
  }

  public void setResponseId(String responseId) {
    this.responseId = responseId;
  }

  public Response200ForPaymentCancellationAuthorization status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Indicates the outcome of the request
   * @return status
  */
  @NotNull 
  @Schema(name = "status", description = "Indicates the outcome of the request", requiredMode = Schema.RequiredMode.REQUIRED)
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Response200ForPaymentCancellationAuthorization data(PaymentCancellationAuthorizationResponseData data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  */
  @Valid 
  @Schema(name = "data", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public PaymentCancellationAuthorizationResponseData getData() {
    return data;
  }

  public void setData(PaymentCancellationAuthorizationResponseData data) {
    this.data = data;
  }

  public Response200ForPaymentCancellationAuthorization errorCode(Integer errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  /**
   * Error code if status is ERROR
   * @return errorCode
  */
  
  @Schema(name = "errorCode", description = "Error code if status is ERROR", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public Integer getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(Integer errorCode) {
    this.errorCode = errorCode;
  }

  public Response200ForPaymentCancellationAuthorization errorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

  /**
   * Error message if status is ERROR
   * @return errorMessage
  */
  
  @Schema(name = "errorMessage", description = "Error message if status is ERROR", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Response200ForPaymentCancellationAuthorization response200ForPaymentCancellationAuthorization = (Response200ForPaymentCancellationAuthorization) o;
    return Objects.equals(this.responseId, response200ForPaymentCancellationAuthorization.responseId) &&
        Objects.equals(this.status, response200ForPaymentCancellationAuthorization.status) &&
        Objects.equals(this.data, response200ForPaymentCancellationAuthorization.data) &&
        Objects.equals(this.errorCode, response200ForPaymentCancellationAuthorization.errorCode) &&
        Objects.equals(this.errorMessage, response200ForPaymentCancellationAuthorization.errorMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseId, status, data, errorCode, errorMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Response200ForPaymentCancellationAuthorization {\n");
    sb.append("    responseId: ").append(toIndentedString(responseId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
