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
public class UpdatePaymentAuthorisationData {

  @JsonProperty("authenticationMethodId")
  private String authenticationMethodId;

  @JsonProperty("scaAuthenticationData")
  private String scaAuthenticationData;

  public UpdatePaymentAuthorisationData authenticationMethodId(String authenticationMethodId) {
    this.authenticationMethodId = authenticationMethodId;
    return this;
  }

  @Schema(description = "Identification of the authentication method")
  public String getAuthenticationMethodId() {
    return authenticationMethodId;
  }

  public void setAuthenticationMethodId(String authenticationMethodId) {
    this.authenticationMethodId = authenticationMethodId;
  }

  public UpdatePaymentAuthorisationData scaAuthenticationData(String scaAuthenticationData) {
    this.scaAuthenticationData = scaAuthenticationData;
    return this;
  }

  @Schema(description = "SCA authentication data (e.g., OTP, authorization code)")
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
    UpdatePaymentAuthorisationData updatePaymentAuthorisationData = (UpdatePaymentAuthorisationData) o;
    return Objects.equals(this.authenticationMethodId, updatePaymentAuthorisationData.authenticationMethodId) &&
        Objects.equals(this.scaAuthenticationData, updatePaymentAuthorisationData.scaAuthenticationData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authenticationMethodId, scaAuthenticationData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdatePaymentAuthorisationData {\n");
    sb.append("    authenticationMethodId: ").append(toIndentedString(authenticationMethodId)).append("\n");
    sb.append("    scaAuthenticationData: ").append(toIndentedString(scaAuthenticationData)).append("\n");
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
