package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.constraints.NotNull;

/**
 * Defines the context data related to the application update.
 */
@Schema(description = "Defines the context data related to the application update.")
public class AppUpdateProcessData {

  @Schema(description = "OAuth Application Data. Mandatory for pre-process-application-update.")
  @JsonProperty("appData")
  @NotNull
  private Object appData;

  @Schema(description = "Additional properties retrieved from devportal UI. Mandatory for pre-process-application-update.")
  @JsonProperty("additionalProperties")
  @NotNull
  private Object additionalProperties;

  @Schema(description = "Existing OAuth Application Data. Mandatory for pre-process-application-update.")
  @JsonProperty("existingAppData")
  @NotNull
  private Object existingAppData;

  /**
   * OAuth Application Data. Mandatory for pre-process-application-update.
   * @return appData
   */
  public Object getAppData() {
    return appData;
  }

  public void setAppData(Object appData) {
    this.appData = appData;
  }

  /**
   * Additional properties retrieved from devportal UI. Mandatory for pre-process-application-update.
   * @return additionalProperties
   */
  public Object getAdditionalProperties() {
    return additionalProperties;
  }

  public void setAdditionalProperties(Object additionalProperties) {
    this.additionalProperties = additionalProperties;
  }

  /**
   * Existing OAuth Application Data. Mandatory for pre-process-application-update.
   * @return existingAppData
   */
  public Object getExistingAppData() {
    return existingAppData;
  }

  public void setExistingAppData(Object existingAppData) {
    this.existingAppData = existingAppData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppUpdateProcessData that = (AppUpdateProcessData) o;
    return Objects.equals(this.appData, that.appData) &&
        Objects.equals(this.additionalProperties, that.additionalProperties) &&
        Objects.equals(this.existingAppData, that.existingAppData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appData, additionalProperties, existingAppData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppUpdateProcessData {\n");
    sb.append("    appData: ").append(toIndentedString(appData)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
    sb.append("    existingAppData: ").append(toIndentedString(existingAppData)).append("\n");
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