package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class SuccessResponseForEventWithDetails_data {

  @Schema(description = "")
  @JsonProperty("callbackUrl")
  private String callbackUrl;

  @Schema(description = "")
  @JsonProperty("version")
  private String version;

  @Schema(description = "")
  @JsonProperty("eventTypes")
  private List<String> eventTypes;

  /**
   * 
   * @return callbackUrl
   */
  public String getCallbackUrl() {
    return callbackUrl;
  }

  public void setCallbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
  }

  /**
   * 
   * @return version
   */
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  /**
   * 
   * @return eventTypes
   */
  public List<String> getEventTypes() {
    return eventTypes;
  }

  public void setEventTypes(List<String> eventTypes) {
    this.eventTypes = eventTypes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponseForEventWithDetails_data that = (SuccessResponseForEventWithDetails_data) o;
    return Objects.equals(this.callbackUrl, that.callbackUrl) &&
        Objects.equals(this.version, that.version) &&
        Objects.equals(this.eventTypes, that.eventTypes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(callbackUrl, version, eventTypes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseForEventWithDetails_data {\n");
    sb.append("    callbackUrl: ").append(toIndentedString(callbackUrl)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    eventTypes: ").append(toIndentedString(eventTypes)).append("\n");
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