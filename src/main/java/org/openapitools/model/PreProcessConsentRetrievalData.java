package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class PreProcessConsentRetrievalData {

  @Schema(description = "The consent id")
  @JsonProperty("consentId")
  private String consentId;

  @Schema(description = "")
  @JsonProperty("consentResource")
  private StoredBasicConsentResourceData consentResource;

  @Schema(description = "Request headers sent by the TPP. Filtered set of headers are sent to the external service.")
  @JsonProperty("requestHeaders")
  private Object requestHeaders;

  @Schema(description = "Resource url")
  @JsonProperty("consentResourcePath")
  private String consentResourcePath;

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
  public StoredBasicConsentResourceData getConsentResource() {
    return consentResource;
  }

  public void setConsentResource(StoredBasicConsentResourceData consentResource) {
    this.consentResource = consentResource;
  }

  /**
   * Request headers sent by the TPP. Filtered set of headers are sent to the external service.
   * @return requestHeaders
   */
  public Object getRequestHeaders() {
    return requestHeaders;
  }

  public void setRequestHeaders(Object requestHeaders) {
    this.requestHeaders = requestHeaders;
  }

  /**
   * Resource url
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
    PreProcessConsentRetrievalData that = (PreProcessConsentRetrievalData) o;
    return Objects.equals(this.consentId, that.consentId) &&
        Objects.equals(this.consentResource, that.consentResource) &&
        Objects.equals(this.requestHeaders, that.requestHeaders) &&
        Objects.equals(this.consentResourcePath, that.consentResourcePath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentId, consentResource, requestHeaders, consentResourcePath);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PreProcessConsentRetrievalData {\n");
    sb.append("    consentId: ").append(toIndentedString(consentId)).append("\n");
    sb.append("    consentResource: ").append(toIndentedString(consentResource)).append("\n");
    sb.append("    requestHeaders: ").append(toIndentedString(requestHeaders)).append("\n");
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