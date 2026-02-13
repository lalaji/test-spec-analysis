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
public class PersistAuthorizedConsentRequestBody {

  @Schema(description = "")
  @JsonProperty("requestId")
  @NotNull
  private String requestId;

  @Schema(description = "")
  @JsonProperty("data")
  @NotNull
  private PersistAuthorizedConsent data;

  /**
   * 
   * @return requestId
   */
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  /**
   * 
   * @return data
   */
  public PersistAuthorizedConsent getData() {
    return data;
  }

  public void setData(PersistAuthorizedConsent data) {
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
    PersistAuthorizedConsentRequestBody that = (PersistAuthorizedConsentRequestBody) o;
    return Objects.equals(this.requestId, that.requestId) &&
        Objects.equals(this.data, that.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestId, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersistAuthorizedConsentRequestBody {\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
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