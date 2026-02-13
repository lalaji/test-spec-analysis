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
public class UpdatePaymentAuthorisationRequestBody {

  @JsonProperty("requestId")
  private String requestId;

  @JsonProperty("data")
  private UpdatePaymentAuthorisationData data;

  public UpdatePaymentAuthorisationRequestBody requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

  @Schema(description = "A unique correlation identifier", example = "Ec1wMjmiG8")
  @NotNull
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public UpdatePaymentAuthorisationRequestBody data(UpdatePaymentAuthorisationData data) {
    this.data = data;
    return this;
  }

  @Schema(description = "")
  @NotNull
  @Valid
  public UpdatePaymentAuthorisationData getData() {
    return data;
  }

  public void setData(UpdatePaymentAuthorisationData data) {
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
    UpdatePaymentAuthorisationRequestBody updatePaymentAuthorisationRequestBody = (UpdatePaymentAuthorisationRequestBody) o;
    return Objects.equals(this.requestId, updatePaymentAuthorisationRequestBody.requestId) &&
        Objects.equals(this.data, updatePaymentAuthorisationRequestBody.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestId, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdatePaymentAuthorisationRequestBody {\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
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
