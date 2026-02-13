package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.constraints.NotNull;

/**
 */
@Schema(description = "")
public class FailedResponseApplicationProcess {

  @Schema(description = "Indicates the outcome of the request. For a failed operation, this should be set to ERROR.")
  @JsonProperty("status")
  @NotNull
  private String status;

  @Schema(description = "")
  @JsonProperty("errorMessage")
  private FailedResponseApplicationProcessData errorMessage;

  /**
   * Indicates the outcome of the request. For a failed operation, this should be set to ERROR.
   * @return status
   */
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * 
   * @return errorMessage
   */
  public FailedResponseApplicationProcessData getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(FailedResponseApplicationProcessData errorMessage) {
    this.errorMessage = errorMessage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FailedResponseApplicationProcess that = (FailedResponseApplicationProcess) o;
    return Objects.equals(this.status, that.status) &&
        Objects.equals(this.errorMessage, that.errorMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, errorMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FailedResponseApplicationProcess {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
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