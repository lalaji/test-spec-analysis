package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 * Defines the success response.
 */
@Schema(description = "Defines the success response.")
public class SuccessResponseClientProcess_data {

  @Schema(description = "")
  @JsonProperty("clientData")
  private Object clientData;

  /**
   * 
   * @return clientData
   */
  public Object getClientData() {
    return clientData;
  }

  public void setClientData(Object clientData) {
    this.clientData = clientData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponseClientProcess_data that = (SuccessResponseClientProcess_data) o;
    return Objects.equals(this.clientData, that.clientData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseClientProcess_data {\n");
    sb.append("    clientData: ").append(toIndentedString(clientData)).append("\n");
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