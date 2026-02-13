package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class UserGrantedData {

  @Schema(description = "")
  @JsonProperty("requestParameters")
  private Object requestParameters;

  @Schema(description = "")
  @JsonProperty("authorizedResources")
  private AuthorizedResources authorizedResources;

  @Schema(description = "")
  @JsonProperty("userId")
  private String userId;

  /**
   * 
   * @return requestParameters
   */
  public Object getRequestParameters() {
    return requestParameters;
  }

  public void setRequestParameters(Object requestParameters) {
    this.requestParameters = requestParameters;
  }

  /**
   * 
   * @return authorizedResources
   */
  public AuthorizedResources getAuthorizedResources() {
    return authorizedResources;
  }

  public void setAuthorizedResources(AuthorizedResources authorizedResources) {
    this.authorizedResources = authorizedResources;
  }

  /**
   * 
   * @return userId
   */
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserGrantedData that = (UserGrantedData) o;
    return Objects.equals(this.requestParameters, that.requestParameters) &&
        Objects.equals(this.authorizedResources, that.authorizedResources) &&
        Objects.equals(this.userId, that.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestParameters, authorizedResources, userId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserGrantedData {\n");
    sb.append("    requestParameters: ").append(toIndentedString(requestParameters)).append("\n");
    sb.append("    authorizedResources: ").append(toIndentedString(authorizedResources)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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