package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class EventPollingRequest {

  @Schema(description = "Event polling data")
  @JsonProperty("eventPollingData")
  private Object eventPollingData;

  /**
   * Event polling data
   * @return eventPollingData
   */
  public Object getEventPollingData() {
    return eventPollingData;
  }

  public void setEventPollingData(Object eventPollingData) {
    this.eventPollingData = eventPollingData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventPollingRequest that = (EventPollingRequest) o;
    return Objects.equals(this.eventPollingData, that.eventPollingData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventPollingData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventPollingRequest {\n");
    sb.append("    eventPollingData: ").append(toIndentedString(eventPollingData)).append("\n");
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