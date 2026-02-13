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
public class SuccessResponseUpdatePaymentAuthorisation {

  @JsonProperty("responseId")
  private String responseId;

  @JsonProperty("status")
  private String status;

  @JsonProperty("data")
  private SuccessResponseUpdatePaymentAuthorisationData data;

  public SuccessResponseUpdatePaymentAuthorisation responseId(String responseId) {
    this.responseId = responseId;
    return this;
  }

  @Schema(description = "")
  @NotNull
  public String getResponseId() {
    return responseId;
  }

  public void setResponseId(String responseId) {
    this.responseId = responseId;
  }

  public SuccessResponseUpdatePaymentAuthorisation status(String status) {
    this.status = status;
    return this;
  }

  @Schema(description = "")
  @NotNull
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public SuccessResponseUpdatePaymentAuthorisation data(SuccessResponseUpdatePaymentAuthorisationData data) {
    this.data = data;
    return this;
  }

  @Schema(description = "")
  @NotNull
  @Valid
  public SuccessResponseUpdatePaymentAuthorisationData getData() {
    return data;
  }

  public void setData(SuccessResponseUpdatePaymentAuthorisationData data) {
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
    SuccessResponseUpdatePaymentAuthorisation successResponseUpdatePaymentAuthorisation = (SuccessResponseUpdatePaymentAuthorisation) o;
    return Objects.equals(this.responseId, successResponseUpdatePaymentAuthorisation.responseId) &&
        Objects.equals(this.status, successResponseUpdatePaymentAuthorisation.status) &&
        Objects.equals(this.data, successResponseUpdatePaymentAuthorisation.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseId, status, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseUpdatePaymentAuthorisation {\n");
    sb.append("    responseId: ").append(toIndentedString(responseId)).append("\n");
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
