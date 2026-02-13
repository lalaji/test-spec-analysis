package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class SuccessResponseIssueRefreshTokenData {

  @Schema(description = "")
  @JsonProperty("issueRefreshToken")
  private Boolean issueRefreshToken;

  @Schema(description = "")
  @JsonProperty("refreshTokenValidityPeriod")
  private Long refreshTokenValidityPeriod;

  /**
   * 
   * @return issueRefreshToken
   */
  public Boolean getIssueRefreshToken() {
    return issueRefreshToken;
  }

  public void setIssueRefreshToken(Boolean issueRefreshToken) {
    this.issueRefreshToken = issueRefreshToken;
  }

  /**
   * 
   * @return refreshTokenValidityPeriod
   */
  public Long getRefreshTokenValidityPeriod() {
    return refreshTokenValidityPeriod;
  }

  public void setRefreshTokenValidityPeriod(Long refreshTokenValidityPeriod) {
    this.refreshTokenValidityPeriod = refreshTokenValidityPeriod;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponseIssueRefreshTokenData that = (SuccessResponseIssueRefreshTokenData) o;
    return Objects.equals(this.issueRefreshToken, that.issueRefreshToken) &&
        Objects.equals(this.refreshTokenValidityPeriod, that.refreshTokenValidityPeriod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(issueRefreshToken, refreshTokenValidityPeriod);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseIssueRefreshTokenData {\n");
    sb.append("    issueRefreshToken: ").append(toIndentedString(issueRefreshToken)).append("\n");
    sb.append("    refreshTokenValidityPeriod: ").append(toIndentedString(refreshTokenValidityPeriod)).append("\n");
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