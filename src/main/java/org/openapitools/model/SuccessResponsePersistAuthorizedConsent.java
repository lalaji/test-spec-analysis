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
public class SuccessResponsePersistAuthorizedConsent {

  @Schema(description = "")
  @JsonProperty("responseId")
  @NotNull
  private String responseId;

  @Schema(description = "")
  @JsonProperty("status")
  @NotNull
  private String status;

  @Schema(description = "")
  @JsonProperty("data")
  @NotNull
  private SuccessResponsePersistAuthorizedConsent_data data;

  /**
   * 
   * @return responseId
   */
  public String getResponseId() {
    return responseId;
  }

  public void setResponseId(String responseId) {
    this.responseId = responseId;
  }

  /**
   * 
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
   * @return data
   */
  public SuccessResponsePersistAuthorizedConsent_data getData() {
    return data;
  }

  public void setData(SuccessResponsePersistAuthorizedConsent_data data) {
    this.data = data;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponsePersistAuthorizedConsent that = (SuccessResponsePersistAuthorizedConsent) o;
    return Objects.equals(this.responseId, that.responseId) &&
        Objects.equals(this.status, that.status) &&
        Objects.equals(this.data, that.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseId, status, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponsePersistAuthorizedConsent {\n");
    sb.append("    responseId: ").append(toIndentedString(responseId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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