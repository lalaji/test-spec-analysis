package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class SuccessResponseWithDetailedConsentDataAndAmendments {

  @Schema(description = "")
  @JsonProperty("consentResource")
  private DetailedConsentResourceDataWithAmendments consentResource;

  /**
   * 
   * @return consentResource
   */
  public DetailedConsentResourceDataWithAmendments getConsentResource() {
    return consentResource;
  }

  public void setConsentResource(DetailedConsentResourceDataWithAmendments consentResource) {
    this.consentResource = consentResource;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponseWithDetailedConsentDataAndAmendments that = (SuccessResponseWithDetailedConsentDataAndAmendments) o;
    return Objects.equals(this.consentResource, that.consentResource);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentResource);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseWithDetailedConsentDataAndAmendments {\n");
    sb.append("    consentResource: ").append(toIndentedString(consentResource)).append("\n");
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