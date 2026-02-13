package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.constraints.NotNull;

/**
 */
@Schema(description = "")
public class FailedResponseInConsentAuthorizeData {

  @Schema(description = "Error message to be displayed in the URL")
  @JsonProperty("errorMessage")
  @NotNull
  private String errorMessage;

  @Schema(description = "New consent status to be set to the consent")
  @JsonProperty("newConsentStatus")
  private String newConsentStatus;

  /**
   * Error message to be displayed in the URL
   * @return errorMessage
   */
  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  /**
   * New consent status to be set to the consent
   * @return newConsentStatus
   */
  public String getNewConsentStatus() {
    return newConsentStatus;
  }

  public void setNewConsentStatus(String newConsentStatus) {
    this.newConsentStatus = newConsentStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FailedResponseInConsentAuthorizeData that = (FailedResponseInConsentAuthorizeData) o;
    return Objects.equals(this.errorMessage, that.errorMessage) &&
        Objects.equals(this.newConsentStatus, that.newConsentStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorMessage, newConsentStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FailedResponseInConsentAuthorizeData {\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
    sb.append("    newConsentStatus: ").append(toIndentedString(newConsentStatus)).append("\n");
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