package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class RequestForEnrichFileUploadResponse {

  @Schema(description = "To identify consent.")
  @JsonProperty("consentId")
  private String consentId;

  @Schema(description = "Timestamp which the file was stored in the database.")
  @JsonProperty("fileUploadCreatedTime")
  private String fileUploadCreatedTime;

  /**
   * To identify consent.
   * @return consentId
   */
  public String getConsentId() {
    return consentId;
  }

  public void setConsentId(String consentId) {
    this.consentId = consentId;
  }

  /**
   * Timestamp which the file was stored in the database.
   * @return fileUploadCreatedTime
   */
  public String getFileUploadCreatedTime() {
    return fileUploadCreatedTime;
  }

  public void setFileUploadCreatedTime(String fileUploadCreatedTime) {
    this.fileUploadCreatedTime = fileUploadCreatedTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestForEnrichFileUploadResponse that = (RequestForEnrichFileUploadResponse) o;
    return Objects.equals(this.consentId, that.consentId) &&
        Objects.equals(this.fileUploadCreatedTime, that.fileUploadCreatedTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentId, fileUploadCreatedTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestForEnrichFileUploadResponse {\n");
    sb.append("    consentId: ").append(toIndentedString(consentId)).append("\n");
    sb.append("    fileUploadCreatedTime: ").append(toIndentedString(fileUploadCreatedTime)).append("\n");
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