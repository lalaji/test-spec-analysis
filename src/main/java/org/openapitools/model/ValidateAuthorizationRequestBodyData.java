package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 * full request object
 */
@Schema(description = "full request object")
public class ValidateAuthorizationRequestBodyData {

  @Schema(description = "")
  @JsonProperty("requestObject")
  private Object requestObject;

  /**
   * 
   * @return requestObject
   */
  public Object getRequestObject() {
    return requestObject;
  }

  public void setRequestObject(Object requestObject) {
    this.requestObject = requestObject;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidateAuthorizationRequestBodyData that = (ValidateAuthorizationRequestBodyData) o;
    return Objects.equals(this.requestObject, that.requestObject);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestObject);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidateAuthorizationRequestBodyData {\n");
    sb.append("    requestObject: ").append(toIndentedString(requestObject)).append("\n");
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