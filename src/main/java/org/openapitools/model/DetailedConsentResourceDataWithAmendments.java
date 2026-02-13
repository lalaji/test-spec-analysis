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
public class DetailedConsentResourceDataWithAmendments {

  @Schema(description = "")
  @JsonProperty("type")
  private String type;

  @Schema(description = "")
  @JsonProperty("status")
  private String status;

  @Schema(description = "")
  @JsonProperty("validityTime")
  private Long validityTime;

  @Schema(description = "")
  @JsonProperty("recurringIndicator")
  private Boolean recurringIndicator;

  @Schema(description = "")
  @JsonProperty("frequency")
  private Integer frequency;

  @Schema(description = "")
  @JsonProperty("receipt")
  private Object receipt;

  @Schema(description = "")
  @JsonProperty("attributes")
  private Object attributes;

  @Schema(description = "")
  @JsonProperty("authorizations")
  private List<Authorization> authorizations;

  @Schema(description = "")
  @JsonProperty("amendments")
  private List<AmendedAuthorization> amendments;

  /**
   * 
   * @return type
   */
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  /**
   * 
   * @return status
   */
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * 
   * @return validityTime
   */
  public Long getValidityTime() {
    return validityTime;
  }

  public void setValidityTime(Long validityTime) {
    this.validityTime = validityTime;
  }

  /**
   * 
   * @return recurringIndicator
   */
  public Boolean getRecurringIndicator() {
    return recurringIndicator;
  }

  public void setRecurringIndicator(Boolean recurringIndicator) {
    this.recurringIndicator = recurringIndicator;
  }

  /**
   * 
   * @return frequency
   */
  public Integer getFrequency() {
    return frequency;
  }

  public void setFrequency(Integer frequency) {
    this.frequency = frequency;
  }

  /**
   * 
   * @return receipt
   */
  public Object getReceipt() {
    return receipt;
  }

  public void setReceipt(Object receipt) {
    this.receipt = receipt;
  }

  /**
   * 
   * @return attributes
   */
  public Object getAttributes() {
    return attributes;
  }

  public void setAttributes(Object attributes) {
    this.attributes = attributes;
  }

  /**
   * 
   * @return authorizations
   */
  public List<Authorization> getAuthorizations() {
    return authorizations;
  }

  public void setAuthorizations(List<Authorization> authorizations) {
    this.authorizations = authorizations;
  }

  /**
   * 
   * @return amendments
   */
  public List<AmendedAuthorization> getAmendments() {
    return amendments;
  }

  public void setAmendments(List<AmendedAuthorization> amendments) {
    this.amendments = amendments;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DetailedConsentResourceDataWithAmendments that = (DetailedConsentResourceDataWithAmendments) o;
    return Objects.equals(this.type, that.type) &&
        Objects.equals(this.status, that.status) &&
        Objects.equals(this.validityTime, that.validityTime) &&
        Objects.equals(this.recurringIndicator, that.recurringIndicator) &&
        Objects.equals(this.frequency, that.frequency) &&
        Objects.equals(this.receipt, that.receipt) &&
        Objects.equals(this.attributes, that.attributes) &&
        Objects.equals(this.authorizations, that.authorizations) &&
        Objects.equals(this.amendments, that.amendments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, status, validityTime, recurringIndicator, frequency, receipt, attributes, authorizations, amendments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DetailedConsentResourceDataWithAmendments {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    validityTime: ").append(toIndentedString(validityTime)).append("\n");
    sb.append("    recurringIndicator: ").append(toIndentedString(recurringIndicator)).append("\n");
    sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
    sb.append("    receipt: ").append(toIndentedString(receipt)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    authorizations: ").append(toIndentedString(authorizations)).append("\n");
    sb.append("    amendments: ").append(toIndentedString(amendments)).append("\n");
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