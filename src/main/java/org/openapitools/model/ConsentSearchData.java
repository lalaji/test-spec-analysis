package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class ConsentSearchData {

  @Schema(description = "")
  @JsonProperty("searchType")
  private String searchType;

  @Schema(description = "payload")
  @JsonProperty("searchResult")
  private Object searchResult;

  @Schema(description = "query params")
  @JsonProperty("enrichmentParams")
  private Object enrichmentParams;

  /**
   * 
   * @return searchType
   */
  public String getSearchType() {
    return searchType;
  }

  public void setSearchType(String searchType) {
    this.searchType = searchType;
  }

  /**
   * payload
   * @return searchResult
   */
  public Object getSearchResult() {
    return searchResult;
  }

  public void setSearchResult(Object searchResult) {
    this.searchResult = searchResult;
  }

  /**
   * query params
   * @return enrichmentParams
   */
  public Object getEnrichmentParams() {
    return enrichmentParams;
  }

  public void setEnrichmentParams(Object enrichmentParams) {
    this.enrichmentParams = enrichmentParams;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsentSearchData that = (ConsentSearchData) o;
    return Objects.equals(this.searchType, that.searchType) &&
        Objects.equals(this.searchResult, that.searchResult) &&
        Objects.equals(this.enrichmentParams, that.enrichmentParams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(searchType, searchResult, enrichmentParams);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsentSearchData {\n");
    sb.append("    searchType: ").append(toIndentedString(searchType)).append("\n");
    sb.append("    searchResult: ").append(toIndentedString(searchResult)).append("\n");
    sb.append("    enrichmentParams: ").append(toIndentedString(enrichmentParams)).append("\n");
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