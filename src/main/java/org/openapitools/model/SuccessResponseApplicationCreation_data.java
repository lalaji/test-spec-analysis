package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class SuccessResponseApplicationCreation_data {

  @Schema(description = "Unique id to be stored as the clientId")
  @JsonProperty("clientId")
  private String clientId;

  @Schema(description = "Defines the additional properties to store against the application.")
  @JsonProperty("additionalAppData")
  private Object additionalAppData;

  /**
   * Unique id to be stored as the clientId
   * @return clientId
   */
  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  /**
   * Defines the additional properties to store against the application.
   * @return additionalAppData
   */
  public Object getAdditionalAppData() {
    return additionalAppData;
  }

  public void setAdditionalAppData(Object additionalAppData) {
    this.additionalAppData = additionalAppData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponseApplicationCreation_data that = (SuccessResponseApplicationCreation_data) o;
    return Objects.equals(this.clientId, that.clientId) &&
        Objects.equals(this.additionalAppData, that.additionalAppData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, additionalAppData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseApplicationCreation_data {\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    additionalAppData: ").append(toIndentedString(additionalAppData)).append("\n");
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