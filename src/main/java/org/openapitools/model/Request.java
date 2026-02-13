package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class Request {

  @Schema(description = "The initiation payload used by third parties which includes detailed information on data access request.")
  @JsonProperty("consentInitiationData")
  private Object consentInitiationData;

  @Schema(description = "Request headers sent by the TPP. Filtered set of headers are sent to the external service.")
  @JsonProperty("requestHeaders")
  private Object requestHeaders;

  @Schema(description = "To identify requested consent type")
  @JsonProperty("consentResourcePath")
  private String consentResourcePath;

  /**
   * The initiation payload used by third parties which includes detailed information on data access request.
   * @return consentInitiationData
   */
  public Object getConsentInitiationData() {
    return consentInitiationData;
  }

  public void setConsentInitiationData(Object consentInitiationData) {
    this.consentInitiationData = consentInitiationData;
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
   * To identify requested consent type
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
    Request that = (Request) o;
    return Objects.equals(this.consentInitiationData, that.consentInitiationData) &&
        Objects.equals(this.requestHeaders, that.requestHeaders) &&
        Objects.equals(this.consentResourcePath, that.consentResourcePath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentInitiationData, requestHeaders, consentResourcePath);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Request {\n");
    sb.append("    consentInitiationData: ").append(toIndentedString(consentInitiationData)).append("\n");
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