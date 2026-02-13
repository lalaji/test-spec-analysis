package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class AuthorizedResources {

  @Schema(description = "Whether the user approved the consent")
  @JsonProperty("approval")
  private Boolean approval;

  @Schema(description = "Indicates if this was a reauthorization flow (optional)")
  @JsonProperty("isReauthorization")
  private Boolean isReauthorization;

  @Schema(description = "Type of consent granted (e.g., 'accounts', 'payments', etc.)")
  @JsonProperty("type")
  private String type;

  @Schema(description = "List of granted permissions and corresponding user-selected account data")
  @JsonProperty("authorizedData")
  private List<AuthorizedResources_authorizedData_inner> authorizedData;

  @Schema(description = "Consent authorization related metadata.")
  @JsonProperty("metadata")
  private Object metadata;

  /**
   * Whether the user approved the consent
   * @return approval
   */
  public Boolean getApproval() {
    return approval;
  }

  public void setApproval(Boolean approval) {
    this.approval = approval;
  }

  /**
   * Indicates if this was a reauthorization flow (optional)
   * @return isReauthorization
   */
  public Boolean getIsReauthorization() {
    return isReauthorization;
  }

  public void setIsReauthorization(Boolean isReauthorization) {
    this.isReauthorization = isReauthorization;
  }

  /**
   * Type of consent granted (e.g., 'accounts', 'payments', etc.)
   * @return type
   */
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  /**
   * List of granted permissions and corresponding user-selected account data
   * @return authorizedData
   */
  public List<AuthorizedResources_authorizedData_inner> getAuthorizedData() {
    return authorizedData;
  }

  public void setAuthorizedData(List<AuthorizedResources_authorizedData_inner> authorizedData) {
    this.authorizedData = authorizedData;
  }

  /**
   * Consent authorization related metadata.
   * @return metadata
   */
  public Object getMetadata() {
    return metadata;
  }

  public void setMetadata(Object metadata) {
    this.metadata = metadata;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthorizedResources that = (AuthorizedResources) o;
    return Objects.equals(this.approval, that.approval) &&
        Objects.equals(this.isReauthorization, that.isReauthorization) &&
        Objects.equals(this.type, that.type) &&
        Objects.equals(this.authorizedData, that.authorizedData) &&
        Objects.equals(this.metadata, that.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(approval, isReauthorization, type, authorizedData, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthorizedResources {\n");
    sb.append("    approval: ").append(toIndentedString(approval)).append("\n");
    sb.append("    isReauthorization: ").append(toIndentedString(isReauthorization)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    authorizedData: ").append(toIndentedString(authorizedData)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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