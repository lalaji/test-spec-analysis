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
public class ErrorResponse {

  @JsonProperty("status")
  private ErrorStatusEnum status;

  @JsonProperty("data")
  private Object data;

  public ErrorResponse status(ErrorStatusEnum status) {
    this.status = status;
    return this;
  }

  @Schema(description = "Indicates the outcome of the request. For an error operation, this should be set to ERROR.")
  @NotNull
  public ErrorStatusEnum getStatus() {
    return status;
  }

  public void setStatus(ErrorStatusEnum status) {
    this.status = status;
  }

  public ErrorResponse data(Object data) {
    this.data = data;
    return this;
  }

  @Schema(description = "Custom error object to response back")
  @NotNull
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
    ErrorResponse errorResponse = (ErrorResponse) o;
    return Objects.equals(this.status, errorResponse.status) &&
        Objects.equals(this.data, errorResponse.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponse {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
