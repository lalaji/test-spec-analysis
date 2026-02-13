package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.constraints.NotNull;

/**
 * Authentication data for CHIP OTP
 */
@Schema(description = "Authentication data for CHIP OTP")
public class ChipOtpAuthenticationData {

  @Schema(description = "The challenge ID from initiation")
  @JsonProperty("challengeId")
  @NotNull
  private String challengeId;

  @Schema(description = "The authentication data (OTP)")
  @JsonProperty("authenticationData")
  @NotNull
  private String authenticationData;

  /**
   * The challenge ID from initiation
   * @return challengeId
   */
  public String getChallengeId() {
    return challengeId;
  }

  public void setChallengeId(String challengeId) {
    this.challengeId = challengeId;
  }

  /**
   * The authentication data (OTP)
   * @return authenticationData
   */
  public String getAuthenticationData() {
    return authenticationData;
  }

  public void setAuthenticationData(String authenticationData) {
    this.authenticationData = authenticationData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChipOtpAuthenticationData that = (ChipOtpAuthenticationData) o;
    return Objects.equals(this.challengeId, that.challengeId) &&
        Objects.equals(this.authenticationData, that.authenticationData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(challengeId, authenticationData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChipOtpAuthenticationData {\n");
    sb.append("    challengeId: ").append(toIndentedString(challengeId)).append("\n");
    sb.append("    authenticationData: ").append(toIndentedString(authenticationData)).append("\n");
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
