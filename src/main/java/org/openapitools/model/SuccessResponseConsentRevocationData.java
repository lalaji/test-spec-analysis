package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class SuccessResponseConsentRevocationData {

  @Schema(description = "Name for the revoked status")
  @JsonProperty("revocationStatusName")
  private String revocationStatusName;

  @Schema(description = "Require access token to be revoked")
  @JsonProperty("requireTokenRevocation")
  private String requireTokenRevocation;

  /**
   * Name for the revoked status
   * @return revocationStatusName
   */
  public String getRevocationStatusName() {
    return revocationStatusName;
  }

  public void setRevocationStatusName(String revocationStatusName) {
    this.revocationStatusName = revocationStatusName;
  }

  /**
   * Require access token to be revoked
   * @return requireTokenRevocation
   */
  public String getRequireTokenRevocation() {
    return requireTokenRevocation;
  }

  public void setRequireTokenRevocation(String requireTokenRevocation) {
    this.requireTokenRevocation = requireTokenRevocation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponseConsentRevocationData that = (SuccessResponseConsentRevocationData) o;
    return Objects.equals(this.revocationStatusName, that.revocationStatusName) &&
        Objects.equals(this.requireTokenRevocation, that.requireTokenRevocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(revocationStatusName, requireTokenRevocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseConsentRevocationData {\n");
    sb.append("    revocationStatusName: ").append(toIndentedString(revocationStatusName)).append("\n");
    sb.append("    requireTokenRevocation: ").append(toIndentedString(requireTokenRevocation)).append("\n");
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