package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 * Defines an error object with details.
 */
@Schema(description = "Defines an error object with details.")
public class Error {

  @Schema(description = "Error code identifying the specific issue.")
  @JsonProperty("code")
  private String code;

  @Schema(description = "Detailed description of the error.")
  @JsonProperty("description")
  private String description;

  @Schema(description = "The operation where the error occurred.")
  @JsonProperty("operation")
  private String operation;

  /**
   * Error code identifying the specific issue.
   * @return code
   */
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  /**
   * Detailed description of the error.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * The operation where the error occurred.
   * @return operation
   */
  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error that = (Error) o;
    return Objects.equals(this.code, that.code) &&
        Objects.equals(this.description, that.description) &&
        Objects.equals(this.operation, that.operation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, description, operation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
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