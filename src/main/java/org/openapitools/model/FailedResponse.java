package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FailedResponse {

  @JsonProperty("responseId")
  private String responseId;

  @JsonProperty("status")
  private String status;

  @JsonProperty("errorCode")
  private Integer errorCode;

  @JsonProperty("data")
  private Object data;

  public FailedResponse responseId(String responseId) {
    this.responseId = responseId;
    return this;
  }

  @Schema(description = "")
  public String getResponseId() {
    return responseId;
  }

  public void setResponseId(String responseId) {
    this.responseId = responseId;
  }

  public FailedResponse status(String status) {
    this.status = status;
    return this;
  }

  @Schema(description = "Indicates the outcome of the request. For a failed operation, this should be set to ERROR.")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public FailedResponse errorCode(Integer errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  @Schema(description = "If any HTTP error code to return.")
  public Integer getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(Integer errorCode) {
    this.errorCode = errorCode;
  }

  public FailedResponse data(Object data) {
    this.data = data;
    return this;
  }

  @Schema(description = ":\"Custom error object to response back\"")
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
    FailedResponse failedResponse = (FailedResponse) o;
    return Objects.equals(this.responseId, failedResponse.responseId) &&
        Objects.equals(this.status, failedResponse.status) &&
        Objects.equals(this.errorCode, failedResponse.errorCode) &&
        Objects.equals(this.data, failedResponse.data);
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
