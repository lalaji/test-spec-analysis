package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.constraints.NotNull;

/**
 * Response for CHIP OTP initiation
 */
@Schema(description = "Response for CHIP OTP initiation")
public class ChipOtpInitiateResponse {

  @Schema(description = "Unique identifier for the response")
  @JsonProperty("responseId")
  @NotNull
  private String responseId;

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

  @Schema(description = "")
  @JsonProperty("status")
  @NotNull
  private StatusEnum status;

  @Schema(description = "")
  @JsonProperty("data")
  private ChipOtpChallengeData data;

  @Schema(description = "Error message if status is ERROR")
  @JsonProperty("errorMessage")
  private String errorMessage;

  @Schema(description = "Detailed error description")
  @JsonProperty("errorDescription")
  private String errorDescription;

  /**
   * Unique identifier for the response
   * @return responseId
   */
  public String getResponseId() {
    return responseId;
  }

  public void setResponseId(String responseId) {
    this.responseId = responseId;
  }

  /**
   * 
   * @return status
   */
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  /**
   * 
   * @return data
   */
  public ChipOtpChallengeData getData() {
    return data;
  }

  public void setData(ChipOtpChallengeData data) {
    this.data = data;
  }

  /**
   * Error message if status is ERROR
   * @return errorMessage
   */
  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  /**
   * Detailed error description
   * @return errorDescription
   */
  public String getErrorDescription() {
    return errorDescription;
  }

  public void setErrorDescription(String errorDescription) {
    this.errorDescription = errorDescription;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChipOtpInitiateResponse that = (ChipOtpInitiateResponse) o;
    return Objects.equals(this.responseId, that.responseId) &&
        Objects.equals(this.status, that.status) &&
        Objects.equals(this.data, that.data) &&
        Objects.equals(this.errorMessage, that.errorMessage) &&
        Objects.equals(this.errorDescription, that.errorDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseId, status, data, errorMessage, errorDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChipOtpInitiateResponse {\n");
    sb.append("    responseId: ").append(toIndentedString(responseId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
    sb.append("    errorDescription: ").append(toIndentedString(errorDescription)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
