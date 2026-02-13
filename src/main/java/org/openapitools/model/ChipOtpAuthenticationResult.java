package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.constraints.NotNull;

/**
 * Result of CHIP OTP authentication attempt
 */
@Schema(description = "Result of CHIP OTP authentication attempt")
public class ChipOtpAuthenticationResult {

  public enum ScaStatusEnum {
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
  @NotNull
  private ScaStatusEnum scaStatus;

  public enum AuthenticationStatusEnum {
    SUCCESS("SUCCESS"),
    FAILED("FAILED");

    private String value;

    AuthenticationStatusEnum(String value) {
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
    public static AuthenticationStatusEnum fromValue(String value) {
      for (AuthenticationStatusEnum b : AuthenticationStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @Schema(description = "Authentication result")
  @JsonProperty("authenticationStatus")
  @NotNull
  private AuthenticationStatusEnum authenticationStatus;

  @Schema(description = "Number of retries remaining for failed authentication")
  @JsonProperty("retriesRemaining")
  private Integer retriesRemaining;

  @Schema(description = "Endpoint for resubmitting authentication data without new challenge")
  @JsonProperty("resubmissionEndpoint")
  private String resubmissionEndpoint;

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
   * Authentication result
   * @return authenticationStatus
   */
  public AuthenticationStatusEnum getAuthenticationStatus() {
    return authenticationStatus;
  }

  public void setAuthenticationStatus(AuthenticationStatusEnum authenticationStatus) {
    this.authenticationStatus = authenticationStatus;
  }

  /**
   * Number of retries remaining for failed authentication
   * @return retriesRemaining
   */
  public Integer getRetriesRemaining() {
    return retriesRemaining;
  }

  public void setRetriesRemaining(Integer retriesRemaining) {
    this.retriesRemaining = retriesRemaining;
  }

  /**
   * Endpoint for resubmitting authentication data without new challenge
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
    ChipOtpAuthenticationResult that = (ChipOtpAuthenticationResult) o;
    return Objects.equals(this.scaStatus, that.scaStatus) &&
        Objects.equals(this.authenticationStatus, that.authenticationStatus) &&
        Objects.equals(this.retriesRemaining, that.retriesRemaining) &&
        Objects.equals(this.resubmissionEndpoint, that.resubmissionEndpoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scaStatus, authenticationStatus, retriesRemaining, resubmissionEndpoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChipOtpAuthenticationResult {\n");
    sb.append("    scaStatus: ").append(toIndentedString(scaStatus)).append("\n");
    sb.append("    authenticationStatus: ").append(toIndentedString(authenticationStatus)).append("\n");
    sb.append("    retriesRemaining: ").append(toIndentedString(retriesRemaining)).append("\n");
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
