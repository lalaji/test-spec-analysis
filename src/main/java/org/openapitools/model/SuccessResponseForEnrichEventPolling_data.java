package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class SuccessResponseForEnrichEventPolling_data {

  @Schema(description = "Event Polling Response")
  @JsonProperty("eventPollingResponse")
  private Object eventPollingResponse;

  /**
   * Event Polling Response
   * @return eventPollingResponse
   */
  public Object getEventPollingResponse() {
    return eventPollingResponse;
  }

  public void setEventPollingResponse(Object eventPollingResponse) {
    this.eventPollingResponse = eventPollingResponse;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponseForEnrichEventPolling_data that = (SuccessResponseForEnrichEventPolling_data) o;
    return Objects.equals(this.eventPollingResponse, that.eventPollingResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventPollingResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseForEnrichEventPolling_data {\n");
    sb.append("    eventPollingResponse: ").append(toIndentedString(eventPollingResponse)).append("\n");
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