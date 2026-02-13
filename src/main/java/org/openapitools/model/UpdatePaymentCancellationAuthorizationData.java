package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;

/**
 * Data object for payment cancellation authorization update
 */
@Schema(name = "UpdatePaymentCancellationAuthorizationData", description = "Data object for payment cancellation authorization update")
public class UpdatePaymentCancellationAuthorizationData {

  @JsonProperty("paymentService")
  private String paymentService;

  @JsonProperty("paymentProduct")
  private String paymentProduct;

  @JsonProperty("paymentId")
  private String paymentId;

  @JsonProperty("authorisationId")
  private String authorisationId;

  @JsonProperty("authorizationCode")
  private String authorizationCode;

  @JsonProperty("scaAuthenticationData")
  private String scaAuthenticationData;

  public UpdatePaymentCancellationAuthorizationData paymentService(String paymentService) {
    this.paymentService = paymentService;
    return this;
  }

  /**
   * Type of payment service (e.g., 'payments', 'bulk-payments', 'periodic-payments')
   * @return paymentService
  */
  @NotNull 
  @Schema(name = "paymentService", description = "Type of payment service (e.g., 'payments', 'bulk-payments', 'periodic-payments')", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getPaymentService() {
    return paymentService;
  }

  public void setPaymentService(String paymentService) {
    this.paymentService = paymentService;
  }

  public UpdatePaymentCancellationAuthorizationData paymentProduct(String paymentProduct) {
    this.paymentProduct = paymentProduct;
    return this;
  }

  /**
   * Payment product identifier (e.g., 'sepa-credit-transfers', 'instant-sepa-credit-transfers')
   * @return paymentProduct
  */
  @NotNull 
  @Schema(name = "paymentProduct", description = "Payment product identifier (e.g., 'sepa-credit-transfers', 'instant-sepa-credit-transfers')", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getPaymentProduct() {
    return paymentProduct;
  }

  public void setPaymentProduct(String paymentProduct) {
    this.paymentProduct = paymentProduct;
  }

  public UpdatePaymentCancellationAuthorizationData paymentId(String paymentId) {
    this.paymentId = paymentId;
    return this;
  }

  /**
   * Unique identifier of the payment
   * @return paymentId
  */
  @NotNull 
  @Schema(name = "paymentId", description = "Unique identifier of the payment", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(String paymentId) {
    this.paymentId = paymentId;
  }

  public UpdatePaymentCancellationAuthorizationData authorisationId(String authorisationId) {
    this.authorisationId = authorisationId;
    return this;
  }

  /**
   * Unique identifier of the cancellation authorization
   * @return authorisationId
  */
  @NotNull 
  @Schema(name = "authorisationId", description = "Unique identifier of the cancellation authorization", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getAuthorisationId() {
    return authorisationId;
  }

  public void setAuthorisationId(String authorisationId) {
    this.authorisationId = authorisationId;
  }

  public UpdatePaymentCancellationAuthorizationData authorizationCode(String authorizationCode) {
    this.authorizationCode = authorizationCode;
    return this;
  }

  /**
   * Authorization code for the payment cancellation
   * @return authorizationCode
  */
  
  @Schema(name = "authorizationCode", description = "Authorization code for the payment cancellation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getAuthorizationCode() {
    return authorizationCode;
  }

  public void setAuthorizationCode(String authorizationCode) {
    this.authorizationCode = authorizationCode;
  }

  public UpdatePaymentCancellationAuthorizationData scaAuthenticationData(String scaAuthenticationData) {
    this.scaAuthenticationData = scaAuthenticationData;
    return this;
  }

  /**
   * SCA authentication data for strong customer authentication
   * @return scaAuthenticationData
  */
  
  @Schema(name = "scaAuthenticationData", description = "SCA authentication data for strong customer authentication", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getScaAuthenticationData() {
    return scaAuthenticationData;
  }

  public void setScaAuthenticationData(String scaAuthenticationData) {
    this.scaAuthenticationData = scaAuthenticationData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdatePaymentCancellationAuthorizationData updatePaymentCancellationAuthorizationData = (UpdatePaymentCancellationAuthorizationData) o;
    return Objects.equals(this.paymentService, updatePaymentCancellationAuthorizationData.paymentService) &&
        Objects.equals(this.paymentProduct, updatePaymentCancellationAuthorizationData.paymentProduct) &&
        Objects.equals(this.paymentId, updatePaymentCancellationAuthorizationData.paymentId) &&
        Objects.equals(this.authorisationId, updatePaymentCancellationAuthorizationData.authorisationId) &&
        Objects.equals(this.authorizationCode, updatePaymentCancellationAuthorizationData.authorizationCode) &&
        Objects.equals(this.scaAuthenticationData, updatePaymentCancellationAuthorizationData.scaAuthenticationData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentService, paymentProduct, paymentId, authorisationId, authorizationCode, scaAuthenticationData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdatePaymentCancellationAuthorizationData {\n");
    sb.append("    paymentService: ").append(toIndentedString(paymentService)).append("\n");
    sb.append("    paymentProduct: ").append(toIndentedString(paymentProduct)).append("\n");
    sb.append("    paymentId: ").append(toIndentedString(paymentId)).append("\n");
    sb.append("    authorisationId: ").append(toIndentedString(authorisationId)).append("\n");
    sb.append("    authorizationCode: ").append(toIndentedString(authorizationCode)).append("\n");
    sb.append("    scaAuthenticationData: ").append(toIndentedString(scaAuthenticationData)).append("\n");
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
