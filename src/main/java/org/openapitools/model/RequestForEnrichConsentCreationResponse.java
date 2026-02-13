package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class RequestForEnrichConsentCreationResponse {

  @Schema(description = "To identify requested")
  @JsonProperty("consentId")
  private String consentId;

  @Schema(description = "")
  @JsonProperty("consentResource")
  private StoredDetailedConsentResourceData consentResource;

  @Schema(description = "consent resource path")
  @JsonProperty("consentResourcePath")
  private String consentResourcePath;

  /**
   * To identify requested
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
   * @return consentResource
   */
  public StoredDetailedConsentResourceData getConsentResource() {
    return consentResource;
  }

  public void setConsentResource(StoredDetailedConsentResourceData consentResource) {
    this.consentResource = consentResource;
  }

  /**
   * consent resource path
   * @return consentResourcePath
   */
  public String getConsentResourcePath() {
    return consentResourcePath;
  }

  public void setConsentResourcePath(String consentResourcePath) {
    this.consentResourcePath = consentResourcePath;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestForEnrichConsentCreationResponse that = (RequestForEnrichConsentCreationResponse) o;
    return Objects.equals(this.consentId, that.consentId) &&
        Objects.equals(this.consentResource, that.consentResource) &&
        Objects.equals(this.consentResourcePath, that.consentResourcePath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentId, consentResource, consentResourcePath);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestForEnrichConsentCreationResponse {\n");
    sb.append("    consentId: ").append(toIndentedString(consentId)).append("\n");
    sb.append("    consentResource: ").append(toIndentedString(consentResource)).append("\n");
    sb.append("    consentResourcePath: ").append(toIndentedString(consentResourcePath)).append("\n");
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