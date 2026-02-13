package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class FailedResponseClientProcess_data {

  @Schema(description = "Provides the error code for error.")
  @JsonProperty("error")
  private String error;

  @Schema(description = "Offers a detailed explanation of the error.")
  @JsonProperty("errorDescription")
  private String errorDescription;

  /**
   * Provides the error code for error.
   * @return error
   */
  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  /**
   * Offers a detailed explanation of the error.
   * @return errorDescription
   */
  public String getErrorDescription() {
    return errorDescription;
  }

  public void setErrorDescription(String errorDescription) {
    this.errorDescription = errorDescription;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FailedResponseClientProcess_data that = (FailedResponseClientProcess_data) o;
    return Objects.equals(this.error, that.error) &&
        Objects.equals(this.errorDescription, that.errorDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error, errorDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FailedResponseClientProcess_data {\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    errorDescription: ").append(toIndentedString(errorDescription)).append("\n");
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