package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class PopulateConsentAuthorizeScreenData {

  @Schema(description = "")
  @JsonProperty("consentId")
  private String consentId;

  @Schema(description = "")
  @JsonProperty("userId")
  private String userId;

  @Schema(description = "Custom object with request parameters")
  @JsonProperty("requestParameters")
  private Object requestParameters;

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
   * @return userId
   */
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  /**
   * Custom object with request parameters
   * @return requestParameters
   */
  public Object getRequestParameters() {
    return requestParameters;
  }

  public void setRequestParameters(Object requestParameters) {
    this.requestParameters = requestParameters;
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
    PopulateConsentAuthorizeScreenData that = (PopulateConsentAuthorizeScreenData) o;
    return Objects.equals(this.consentId, that.consentId) &&
        Objects.equals(this.userId, that.userId) &&
        Objects.equals(this.requestParameters, that.requestParameters) &&
        Objects.equals(this.consentResource, that.consentResource);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentId, userId, requestParameters, consentResource);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PopulateConsentAuthorizeScreenData {\n");
    sb.append("    consentId: ").append(toIndentedString(consentId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    requestParameters: ").append(toIndentedString(requestParameters)).append("\n");
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