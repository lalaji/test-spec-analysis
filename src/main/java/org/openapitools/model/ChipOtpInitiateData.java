package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.constraints.NotNull;

/**
 * Data for CHIP OTP initiation
 */
@Schema(description = "Data for CHIP OTP initiation")
public class ChipOtpInitiateData {

  @Schema(description = "The consent ID requiring authentication")
  @JsonProperty("consentId")
  @NotNull
  private String consentId;

  @Schema(description = "User identifier")
  @JsonProperty("userId")
  @NotNull
  private String userId;

  public enum ScaMethodEnum {
    CHIP_OTP("CHIP_OTP"),
    SMS_OTP("SMS_OTP"),
    EMAIL_OTP("EMAIL_OTP");

    private String value;

    ScaMethodEnum(String value) {
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
    public static ScaMethodEnum fromValue(String value) {
      for (ScaMethodEnum b : ScaMethodEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @Schema(description = "Strong Customer Authentication method")
  @JsonProperty("scaMethod")
  @NotNull
  private ScaMethodEnum scaMethod;

  /**
   * The consent ID requiring authentication
   * @return consentId
   */
  public String getConsentId() {
    return consentId;
  }

  public void setConsentId(String consentId) {
    this.consentId = consentId;
  }

  /**
   * User identifier
   * @return userId
   */
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  /**
   * Strong Customer Authentication method
   * @return scaMethod
   */
  public ScaMethodEnum getScaMethod() {
    return scaMethod;
  }

  public void setScaMethod(ScaMethodEnum scaMethod) {
    this.scaMethod = scaMethod;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChipOtpInitiateData that = (ChipOtpInitiateData) o;
    return Objects.equals(this.consentId, that.consentId) &&
        Objects.equals(this.userId, that.userId) &&
        Objects.equals(this.scaMethod, that.scaMethod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentId, userId, scaMethod);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChipOtpInitiateData {\n");
    sb.append("    consentId: ").append(toIndentedString(consentId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    scaMethod: ").append(toIndentedString(scaMethod)).append("\n");
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
