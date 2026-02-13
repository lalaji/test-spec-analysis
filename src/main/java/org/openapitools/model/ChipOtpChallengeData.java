package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.constraints.NotNull;

/**
 * Challenge data for CHIP OTP
 */
@Schema(description = "Challenge data for CHIP OTP")
public class ChipOtpChallengeData {

  @Schema(description = "Unique identifier for the challenge")
  @JsonProperty("challengeId")
  @NotNull
  private String challengeId;

  public enum ScaStatusEnum {
    RECEIVED("received"),
    STARTED("started"),
    FINALISED("finalised"),
    FAILED("failed");

    private String value;

    ScaStatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ScaStatusEnum fromValue(String value) {
      for (ScaStatusEnum b : ScaStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @Schema(description = "Status of Strong Customer Authentication")
  @JsonProperty("scaStatus")
  private ScaStatusEnum scaStatus;

  @Schema(description = "")
  @JsonProperty("challengeData")
  private OtpChallengeDetails challengeData;

  @Schema(description = "Endpoint for authentication data resubmission")
  @JsonProperty("resubmissionEndpoint")
  private String resubmissionEndpoint;

  /**
   * Unique identifier for the challenge
   * @return challengeId
   */
  public String getChallengeId() {
    return challengeId;
  }

  public void setChallengeId(String challengeId) {
    this.challengeId = challengeId;
  }

  /**
   * Status of Strong Customer Authentication
   * @return scaStatus
   */
  public ScaStatusEnum getScaStatus() {
    return scaStatus;
  }

  public void setScaStatus(ScaStatusEnum scaStatus) {
    this.scaStatus = scaStatus;
  }

  /**
   * 
   * @return challengeData
   */
  public OtpChallengeDetails getChallengeData() {
    return challengeData;
  }

  public void setChallengeData(OtpChallengeDetails challengeData) {
    this.challengeData = challengeData;
  }

  /**
   * Endpoint for authentication data resubmission
   * @return resubmissionEndpoint
   */
  public String getResubmissionEndpoint() {
    return resubmissionEndpoint;
  }

  public void setResubmissionEndpoint(String resubmissionEndpoint) {
    this.resubmissionEndpoint = resubmissionEndpoint;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChipOtpChallengeData that = (ChipOtpChallengeData) o;
    return Objects.equals(this.challengeId, that.challengeId) &&
        Objects.equals(this.scaStatus, that.scaStatus) &&
        Objects.equals(this.challengeData, that.challengeData) &&
        Objects.equals(this.resubmissionEndpoint, that.resubmissionEndpoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(challengeId, scaStatus, challengeData, resubmissionEndpoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChipOtpChallengeData {\n");
    sb.append("    challengeId: ").append(toIndentedString(challengeId)).append("\n");
    sb.append("    scaStatus: ").append(toIndentedString(scaStatus)).append("\n");
    sb.append("    challengeData: ").append(toIndentedString(challengeData)).append("\n");
    sb.append("    resubmissionEndpoint: ").append(toIndentedString(resubmissionEndpoint)).append("\n");
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
