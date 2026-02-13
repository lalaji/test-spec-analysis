package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class SuccessResponseForEnrichEventSubscription_data {

  @Schema(description = "Event Subscription Response")
  @JsonProperty("eventSubscriptionResponse")
  private Object eventSubscriptionResponse;

  /**
   * Event Subscription Response
   * @return eventSubscriptionResponse
   */
  public Object getEventSubscriptionResponse() {
    return eventSubscriptionResponse;
  }

  public void setEventSubscriptionResponse(Object eventSubscriptionResponse) {
    this.eventSubscriptionResponse = eventSubscriptionResponse;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponseForEnrichEventSubscription_data that = (SuccessResponseForEnrichEventSubscription_data) o;
    return Objects.equals(this.eventSubscriptionResponse, that.eventSubscriptionResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventSubscriptionResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseForEnrichEventSubscription_data {\n");
    sb.append("    eventSubscriptionResponse: ").append(toIndentedString(eventSubscriptionResponse)).append("\n");
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