package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Request body for updating payment cancellation authorization
 */
@Schema(name = "UpdatePaymentCancellationAuthorizationRequest", description = "Request body for updating payment cancellation authorization")
public class UpdatePaymentCancellationAuthorizationRequest {

  @JsonProperty("requestId")
  private String requestId;

  @JsonProperty("data")
  private UpdatePaymentCancellationAuthorizationData data;

  public UpdatePaymentCancellationAuthorizationRequest requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

  /**
   * A unique correlation identifier
   * @return requestId
  */
  @NotNull 
  @Schema(name = "requestId", description = "A unique correlation identifier", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public UpdatePaymentCancellationAuthorizationRequest data(UpdatePaymentCancellationAuthorizationData data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  */
  @NotNull @Valid 
  @Schema(name = "data", requiredMode = Schema.RequiredMode.REQUIRED)
  public UpdatePaymentCancellationAuthorizationData getData() {
    return data;
  }

  public void setData(UpdatePaymentCancellationAuthorizationData data) {
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
    UpdatePaymentCancellationAuthorizationRequest updatePaymentCancellationAuthorizationRequest = (UpdatePaymentCancellationAuthorizationRequest) o;
    return Objects.equals(this.requestId, updatePaymentCancellationAuthorizationRequest.requestId) &&
        Objects.equals(this.data, updatePaymentCancellationAuthorizationRequest.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestId, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdatePaymentCancellationAuthorizationRequest {\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
