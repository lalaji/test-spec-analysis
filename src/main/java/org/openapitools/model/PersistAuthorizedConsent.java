package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class PersistAuthorizedConsent {

  @Schema(description = "")
  @JsonProperty("consentId")
  private String consentId;

  @Schema(description = "")
  @JsonProperty("isApproved")
  private Boolean isApproved;

  @Schema(description = "")
  @JsonProperty("userGrantedData")
  private UserGrantedData userGrantedData;

  @Schema(description = "")
  @JsonProperty("consentResource")
  private StoredDetailedConsentResourceData consentResource;

  /**
   * 
   * @return consentId
   */
  public String getConsentId() {
    return consentId;
  }

  public void setConsentId(String consentId) {
    this.consentId = consentId;
  }

  /**
   * 
   * @return isApproved
   */
  public Boolean getIsApproved() {
    return isApproved;
  }

  public void setIsApproved(Boolean isApproved) {
    this.isApproved = isApproved;
  }

  /**
   * 
   * @return userGrantedData
   */
  public UserGrantedData getUserGrantedData() {
    return userGrantedData;
  }

  public void setUserGrantedData(UserGrantedData userGrantedData) {
    this.userGrantedData = userGrantedData;
  }

  /**
   * 
   * @return consentResource
   */
  public StoredDetailedConsentResourceData getConsentResource() {
    return consentResource;
  }

  public void setConsentResource(StoredDetailedConsentResourceData consentResource) {
    this.consentResource = consentResource;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersistAuthorizedConsent that = (PersistAuthorizedConsent) o;
    return Objects.equals(this.consentId, that.consentId) &&
        Objects.equals(this.isApproved, that.isApproved) &&
        Objects.equals(this.userGrantedData, that.userGrantedData) &&
        Objects.equals(this.consentResource, that.consentResource);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentId, isApproved, userGrantedData, consentResource);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersistAuthorizedConsent {\n");
    sb.append("    consentId: ").append(toIndentedString(consentId)).append("\n");
    sb.append("    isApproved: ").append(toIndentedString(isApproved)).append("\n");
    sb.append("    userGrantedData: ").append(toIndentedString(userGrantedData)).append("\n");
    sb.append("    consentResource: ").append(toIndentedString(consentResource)).append("\n");
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