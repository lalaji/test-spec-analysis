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
public class SuccessResponseUpdatePaymentAuthorisationData {

  @JsonProperty("scaStatus")
  private String scaStatus;

  @JsonProperty("authorisationId")
  private String authorisationId;

  public SuccessResponseUpdatePaymentAuthorisationData scaStatus(String scaStatus) {
    this.scaStatus = scaStatus;
    return this;
  }

  @Schema(description = "Status of the SCA process (e.g., received, psuIdentified, psuAuthenticated, scaMethodSelected, started, finalised, failed, exempted)")
  public String getScaStatus() {
    return scaStatus;
  }

  public void setScaStatus(String scaStatus) {
    this.scaStatus = scaStatus;
  }

  public SuccessResponseUpdatePaymentAuthorisationData authorisationId(String authorisationId) {
    this.authorisationId = authorisationId;
    return this;
  }

  @Schema(description = "Resource identification of the related SCA")
  public String getAuthorisationId() {
    return authorisationId;
  }

  public void setAuthorisationId(String authorisationId) {
    this.authorisationId = authorisationId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponseUpdatePaymentAuthorisationData successResponseUpdatePaymentAuthorisationData = (SuccessResponseUpdatePaymentAuthorisationData) o;
    return Objects.equals(this.scaStatus, successResponseUpdatePaymentAuthorisationData.scaStatus) &&
        Objects.equals(this.authorisationId, successResponseUpdatePaymentAuthorisationData.authorisationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scaStatus, authorisationId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseUpdatePaymentAuthorisationData {\n");
    sb.append("    scaStatus: ").append(toIndentedString(scaStatus)).append("\n");
    sb.append("    authorisationId: ").append(toIndentedString(authorisationId)).append("\n");
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
