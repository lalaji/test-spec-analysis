package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class SuccessResponseForResponseAlternationData {

  @Schema(description = "Headers to be included in the response.")
  @JsonProperty("responseHeaders")
  private Object responseHeaders;

  @Schema(description = "Generated custom response body")
  @JsonProperty("modifiedResponse")
  private Object modifiedResponse;

  /**
   * Headers to be included in the response.
   * @return responseHeaders
   */
  public Object getResponseHeaders() {
    return responseHeaders;
  }

  public void setResponseHeaders(Object responseHeaders) {
    this.responseHeaders = responseHeaders;
  }

  /**
   * Generated custom response body
   * @return modifiedResponse
   */
  public Object getModifiedResponse() {
    return modifiedResponse;
  }

  public void setModifiedResponse(Object modifiedResponse) {
    this.modifiedResponse = modifiedResponse;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponseForResponseAlternationData that = (SuccessResponseForResponseAlternationData) o;
    return Objects.equals(this.responseHeaders, that.responseHeaders) &&
        Objects.equals(this.modifiedResponse, that.modifiedResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseHeaders, modifiedResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseForResponseAlternationData {\n");
    sb.append("    responseHeaders: ").append(toIndentedString(responseHeaders)).append("\n");
    sb.append("    modifiedResponse: ").append(toIndentedString(modifiedResponse)).append("\n");
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