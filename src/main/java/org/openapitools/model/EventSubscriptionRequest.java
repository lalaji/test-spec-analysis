package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class EventSubscriptionRequest {

  @Schema(description = "")
  @JsonProperty("eventType")
  private String eventType;

  @Schema(description = "Event Subscription Payload")
  @JsonProperty("eventSubscriptionData")
  private Object eventSubscriptionData;

  /**
   * 
   * @return eventType
   */
  public String getEventType() {
    return eventType;
  }

  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  /**
   * Event Subscription Payload
   * @return eventSubscriptionData
   */
  public Object getEventSubscriptionData() {
    return eventSubscriptionData;
  }

  public void setEventSubscriptionData(Object eventSubscriptionData) {
    this.eventSubscriptionData = eventSubscriptionData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventSubscriptionRequest that = (EventSubscriptionRequest) o;
    return Objects.equals(this.eventType, that.eventType) &&
        Objects.equals(this.eventSubscriptionData, that.eventSubscriptionData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventType, eventSubscriptionData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventSubscriptionRequest {\n");
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    eventSubscriptionData: ").append(toIndentedString(eventSubscriptionData)).append("\n");
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