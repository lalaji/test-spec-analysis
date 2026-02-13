package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class ValidateConsentAccessData {

  @Schema(description = "The consent id")
  @JsonProperty("consentId")
  private String consentId;

  @Schema(description = "")
  @JsonProperty("consentResource")
  private StoredDetailedConsentResourceData consentResource;

  @Schema(description = "The receipt used by Third parties which includes detailed information on data access request")
  @JsonProperty("dataRequestPayload")
  private Object dataRequestPayload;

  /**
   * The consent id
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
   * The receipt used by Third parties which includes detailed information on data access request
   * @return dataRequestPayload
   */
  public Object getDataRequestPayload() {
    return dataRequestPayload;
  }

  public void setDataRequestPayload(Object dataRequestPayload) {
    this.dataRequestPayload = dataRequestPayload;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidateConsentAccessData that = (ValidateConsentAccessData) o;
    return Objects.equals(this.consentId, that.consentId) &&
        Objects.equals(this.consentResource, that.consentResource) &&
        Objects.equals(this.dataRequestPayload, that.dataRequestPayload);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentId, consentResource, dataRequestPayload);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidateConsentAccessData {\n");
    sb.append("    consentId: ").append(toIndentedString(consentId)).append("\n");
    sb.append("    consentResource: ").append(toIndentedString(consentResource)).append("\n");
    sb.append("    dataRequestPayload: ").append(toIndentedString(dataRequestPayload)).append("\n");
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