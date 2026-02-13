package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Details about the OTP challenge
 */
@Schema(description = "Details about the OTP challenge")
public class OtpChallengeDetails {

  public enum OtpFormatEnum {
    CHARACTERS("characters"),
    NUMERIC("numeric");

    private String value;

    OtpFormatEnum(String value) {
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
    public static OtpFormatEnum fromValue(String value) {
      for (OtpFormatEnum b : OtpFormatEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @Schema(description = "Format of the OTP (characters or numeric)")
  @JsonProperty("otpFormat")
  private OtpFormatEnum otpFormat;

  @Schema(description = "Length of the OTP")
  @JsonProperty("otpLength")
  @Min(4)
  @Max(8)
  private Integer otpLength;

  /**
   * Format of the OTP (characters or numeric)
   * @return otpFormat
   */
  public OtpFormatEnum getOtpFormat() {
    return otpFormat;
  }

  public void setOtpFormat(OtpFormatEnum otpFormat) {
    this.otpFormat = otpFormat;
  }

  /**
   * Length of the OTP
   * @return otpLength
   */
  public Integer getOtpLength() {
    return otpLength;
  }

  public void setOtpLength(Integer otpLength) {
    this.otpLength = otpLength;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OtpChallengeDetails that = (OtpChallengeDetails) o;
    return Objects.equals(this.otpFormat, that.otpFormat) &&
        Objects.equals(this.otpLength, that.otpLength);
  }

  @Override
  public int hashCode() {
    return Objects.hash(otpFormat, otpLength);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OtpChallengeDetails {\n");
    sb.append("    otpFormat: ").append(toIndentedString(otpFormat)).append("\n");
    sb.append("    otpLength: ").append(toIndentedString(otpLength)).append("\n");
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
