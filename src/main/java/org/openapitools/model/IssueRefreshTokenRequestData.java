package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class IssueRefreshTokenRequestData {

  @Schema(description = "")
  @JsonProperty("grantType")
  private String grantType;

  @Schema(description = "")
  @JsonProperty("consentCreatedTime")
  private Long consentCreatedTime;

  @Schema(description = "")
  @JsonProperty("consentValidityPeriod")
  private Long consentValidityPeriod;

  @Schema(description = "")
  @JsonProperty("defaultRefreshTokenValidityPeriod")
  private Long defaultRefreshTokenValidityPeriod;

  /**
   * 
   * @return grantType
   */
  public String getGrantType() {
    return grantType;
  }

  public void setGrantType(String grantType) {
    this.grantType = grantType;
  }

  /**
   * 
   * @return consentCreatedTime
   */
  public Long getConsentCreatedTime() {
    return consentCreatedTime;
  }

  public void setConsentCreatedTime(Long consentCreatedTime) {
    this.consentCreatedTime = consentCreatedTime;
  }

  /**
   * 
   * @return consentValidityPeriod
   */
  public Long getConsentValidityPeriod() {
    return consentValidityPeriod;
  }

  public void setConsentValidityPeriod(Long consentValidityPeriod) {
    this.consentValidityPeriod = consentValidityPeriod;
  }

  /**
   * 
   * @return defaultRefreshTokenValidityPeriod
   */
  public Long getDefaultRefreshTokenValidityPeriod() {
    return defaultRefreshTokenValidityPeriod;
  }

  public void setDefaultRefreshTokenValidityPeriod(Long defaultRefreshTokenValidityPeriod) {
    this.defaultRefreshTokenValidityPeriod = defaultRefreshTokenValidityPeriod;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssueRefreshTokenRequestData that = (IssueRefreshTokenRequestData) o;
    return Objects.equals(this.grantType, that.grantType) &&
        Objects.equals(this.consentCreatedTime, that.consentCreatedTime) &&
        Objects.equals(this.consentValidityPeriod, that.consentValidityPeriod) &&
        Objects.equals(this.defaultRefreshTokenValidityPeriod, that.defaultRefreshTokenValidityPeriod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(grantType, consentCreatedTime, consentValidityPeriod, defaultRefreshTokenValidityPeriod);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssueRefreshTokenRequestData {\n");
    sb.append("    grantType: ").append(toIndentedString(grantType)).append("\n");
    sb.append("    consentCreatedTime: ").append(toIndentedString(consentCreatedTime)).append("\n");
    sb.append("    consentValidityPeriod: ").append(toIndentedString(consentValidityPeriod)).append("\n");
    sb.append("    defaultRefreshTokenValidityPeriod: ").append(toIndentedString(defaultRefreshTokenValidityPeriod)).append("\n");
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