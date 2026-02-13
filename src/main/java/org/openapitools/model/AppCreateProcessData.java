package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.constraints.NotNull;

/**
 * Defines the context data related to the application registration.
 */
@Schema(description = "Defines the context data related to the application registration.")
public class AppCreateProcessData {

  @Schema(description = "OAuth Application Data. Mandatory for pre-process-application-creation.")
  @JsonProperty("appData")
  @NotNull
  private Object appData;

  @Schema(description = "Additional properties retrieved from devportal UI. Mandatory for pre-process-application-creation.")
  @JsonProperty("additionalProperties")
  @NotNull
  private Object additionalProperties;

  /**
   * OAuth Application Data. Mandatory for pre-process-application-creation.
   * @return appData
   */
  public Object getAppData() {
    return appData;
  }

  public void setAppData(Object appData) {
    this.appData = appData;
  }

  /**
   * Additional properties retrieved from devportal UI. Mandatory for pre-process-application-creation.
   * @return additionalProperties
   */
  public Object getAdditionalProperties() {
    return additionalProperties;
  }

  public void setAdditionalProperties(Object additionalProperties) {
    this.additionalProperties = additionalProperties;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppCreateProcessData that = (AppCreateProcessData) o;
    return Objects.equals(this.appData, that.appData) &&
        Objects.equals(this.additionalProperties, that.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appData, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppCreateProcessData {\n");
    sb.append("    appData: ").append(toIndentedString(appData)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
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