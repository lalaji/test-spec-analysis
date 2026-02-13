package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class SuccessResponseForConsentSearchData {

  @Schema(description = "Enriched search result")
  @JsonProperty("enrichedSearchResult")
  private Object enrichedSearchResult;

  /**
   * Enriched search result
   * @return enrichedSearchResult
   */
  public Object getEnrichedSearchResult() {
    return enrichedSearchResult;
  }

  public void setEnrichedSearchResult(Object enrichedSearchResult) {
    this.enrichedSearchResult = enrichedSearchResult;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponseForConsentSearchData that = (SuccessResponseForConsentSearchData) o;
    return Objects.equals(this.enrichedSearchResult, that.enrichedSearchResult);
  }

  @Override
  public int hashCode() {
    return Objects.hash(enrichedSearchResult);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseForConsentSearchData {\n");
    sb.append("    enrichedSearchResult: ").append(toIndentedString(enrichedSearchResult)).append("\n");
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