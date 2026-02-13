package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class RequestForPreProcessFileUpload {

  @Schema(description = "To identify requested")
  @JsonProperty("consentId")
  private String consentId;

  @Schema(description = "")
  @JsonProperty("consentResource")
  private StoredDetailedConsentResourceData consentResource;

  @Schema(description = "content of the uploaded file")
  @JsonProperty("fileContent")
  private String fileContent;

  @Schema(description = "consent resource path")
  @JsonProperty("consentResourcePath")
  private String consentResourcePath;

  @Schema(description = "Request headers sent by the TPP. Filtered set of headers are sent to the external service.")
  @JsonProperty("requestHeaders")
  private Object requestHeaders;

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
   * content of the uploaded file
   * @return fileContent
   */
  public String getFileContent() {
    return fileContent;
  }

  public void setFileContent(String fileContent) {
    this.fileContent = fileContent;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestForPreProcessFileUpload that = (RequestForPreProcessFileUpload) o;
    return Objects.equals(this.consentId, that.consentId) &&
        Objects.equals(this.consentResource, that.consentResource) &&
        Objects.equals(this.fileContent, that.fileContent) &&
        Objects.equals(this.consentResourcePath, that.consentResourcePath) &&
        Objects.equals(this.requestHeaders, that.requestHeaders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentId, consentResource, fileContent, consentResourcePath, requestHeaders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestForPreProcessFileUpload {\n");
    sb.append("    consentId: ").append(toIndentedString(consentId)).append("\n");
    sb.append("    consentResource: ").append(toIndentedString(consentResource)).append("\n");
    sb.append("    fileContent: ").append(toIndentedString(fileContent)).append("\n");
    sb.append("    consentResourcePath: ").append(toIndentedString(consentResourcePath)).append("\n");
    sb.append("    requestHeaders: ").append(toIndentedString(requestHeaders)).append("\n");
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