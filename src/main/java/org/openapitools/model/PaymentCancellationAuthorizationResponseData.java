package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Response data for payment cancellation authorization
 */
@Schema(name = "PaymentCancellationAuthorizationResponseData", description = "Response data for payment cancellation authorization")
public class PaymentCancellationAuthorizationResponseData {

  @JsonProperty("scaStatus")
  private String scaStatus;

  @JsonProperty("authorisationId")
  private String authorisationId;

  @JsonProperty("psuMessage")
  private String psuMessage;

  public PaymentCancellationAuthorizationResponseData scaStatus(String scaStatus) {
    this.scaStatus = scaStatus;
    return this;
  }

  /**
   * Status of the SCA authentication (e.g., 'received', 'psuAuthenticated', 'scaMethodSelected', 'started', 'finalised', 'failed', 'exempted')
   * @return scaStatus
  */
  
  @Schema(name = "scaStatus", description = "Status of the SCA authentication (e.g., 'received', 'psuAuthenticated', 'scaMethodSelected', 'started', 'finalised', 'failed', 'exempted')", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getScaStatus() {
    return scaStatus;
  }

  public void setScaStatus(String scaStatus) {
    this.scaStatus = scaStatus;
  }

  public PaymentCancellationAuthorizationResponseData authorisationId(String authorisationId) {
    this.authorisationId = authorisationId;
    return this;
  }

  /**
   * Unique identifier of the cancellation authorization
   * @return authorisationId
  */
  
  @Schema(name = "authorisationId", description = "Unique identifier of the cancellation authorization", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getAuthorisationId() {
    return authorisationId;
  }

  public void setAuthorisationId(String authorisationId) {
    this.authorisationId = authorisationId;
  }

  public PaymentCancellationAuthorizationResponseData psuMessage(String psuMessage) {
    this.psuMessage = psuMessage;
    return this;
  }

  /**
   * Message to be displayed to the PSU
   * @return psuMessage
  */
  
  @Schema(name = "psuMessage", description = "Message to be displayed to the PSU", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getPsuMessage() {
    return psuMessage;
  }

  public void setPsuMessage(String psuMessage) {
    this.psuMessage = psuMessage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentCancellationAuthorizationResponseData paymentCancellationAuthorizationResponseData = (PaymentCancellationAuthorizationResponseData) o;
    return Objects.equals(this.scaStatus, paymentCancellationAuthorizationResponseData.scaStatus) &&
        Objects.equals(this.authorisationId, paymentCancellationAuthorizationResponseData.authorisationId) &&
        Objects.equals(this.psuMessage, paymentCancellationAuthorizationResponseData.psuMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scaStatus, authorisationId, psuMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentCancellationAuthorizationResponseData {\n");
    sb.append("    scaStatus: ").append(toIndentedString(scaStatus)).append("\n");
    sb.append("    authorisationId: ").append(toIndentedString(authorisationId)).append("\n");
    sb.append("    psuMessage: ").append(toIndentedString(psuMessage)).append("\n");
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
