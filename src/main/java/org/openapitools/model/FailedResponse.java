package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.constraints.NotNull;

/**
 */
@Schema(description = "")
public class FailedResponse {

  @Schema(description = "")
  @JsonProperty("responseId")
  @NotNull
  private String responseId;

  @Schema(description = "Indicates the outcome of the request. For a failed operation, this should be set to ERROR.")
  @JsonProperty("status")
  @NotNull
  private String status;

  @Schema(description = "If any HTTP error code to return.")
  @JsonProperty("errorCode")
  @NotNull
  private Integer errorCode;

  @Schema(description = ":\"Custom error object to response back\"")
  @JsonProperty("data")
  @NotNull
  private Object data;

  /**
   * 
   * @return responseId
   */
  public String getResponseId() {
    return responseId;
  }

  public void setResponseId(String responseId) {
    this.responseId = responseId;
  }

  /**
   * Indicates the outcome of the request. For a failed operation, this should be set to ERROR.
   * @return status
   */
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * If any HTTP error code to return.
   * @return errorCode
   */
  public Integer getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(Integer errorCode) {
    this.errorCode = errorCode;
  }

  /**
   * :"Custom error object to response back"
   * @return data
   */
  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FailedResponse that = (FailedResponse) o;
    return Objects.equals(this.responseId, that.responseId) &&
        Objects.equals(this.status, that.status) &&
        Objects.equals(this.errorCode, that.errorCode) &&
        Objects.equals(this.data, that.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseId, status, errorCode, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FailedResponse {\n");
    sb.append("    responseId: ").append(toIndentedString(responseId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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