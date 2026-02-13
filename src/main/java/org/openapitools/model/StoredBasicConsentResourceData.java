package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class StoredBasicConsentResourceData {

  @Schema(description = "")
  @JsonProperty("id")
  private String id;

  @Schema(description = "")
  @JsonProperty("receipt")
  private Object receipt;

  @Schema(description = "")
  @JsonProperty("createdTime")
  private Integer createdTime;

  @Schema(description = "")
  @JsonProperty("updatedTime")
  private Integer updatedTime;

  @Schema(description = "")
  @JsonProperty("clientId")
  private String clientId;

  @Schema(description = "")
  @JsonProperty("type")
  private String type;

  @Schema(description = "")
  @JsonProperty("status")
  private String status;

  @Schema(description = "")
  @JsonProperty("frequency")
  private Integer frequency;

  @Schema(description = "")
  @JsonProperty("validityTime")
  private Integer validityTime;

  @Schema(description = "")
  @JsonProperty("recurringIndicator")
  private Boolean recurringIndicator;

  @Schema(description = "")
  @JsonProperty("attributes")
  private Object attributes;

  /**
   * 
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
   * @return createdTime
   */
  public Integer getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Integer createdTime) {
    this.createdTime = createdTime;
  }

  /**
   * 
   * @return updatedTime
   */
  public Integer getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Integer updatedTime) {
    this.updatedTime = updatedTime;
  }

  /**
   * 
   * @return clientId
   */
  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

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
   * @return validityTime
   */
  public Integer getValidityTime() {
    return validityTime;
  }

  public void setValidityTime(Integer validityTime) {
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
   * @return attributes
   */
  public Object getAttributes() {
    return attributes;
  }

  public void setAttributes(Object attributes) {
    this.attributes = attributes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StoredBasicConsentResourceData that = (StoredBasicConsentResourceData) o;
    return Objects.equals(this.id, that.id) &&
        Objects.equals(this.receipt, that.receipt) &&
        Objects.equals(this.createdTime, that.createdTime) &&
        Objects.equals(this.updatedTime, that.updatedTime) &&
        Objects.equals(this.clientId, that.clientId) &&
        Objects.equals(this.type, that.type) &&
        Objects.equals(this.status, that.status) &&
        Objects.equals(this.frequency, that.frequency) &&
        Objects.equals(this.validityTime, that.validityTime) &&
        Objects.equals(this.recurringIndicator, that.recurringIndicator) &&
        Objects.equals(this.attributes, that.attributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, receipt, createdTime, updatedTime, clientId, type, status, frequency, validityTime, recurringIndicator, attributes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StoredBasicConsentResourceData {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    receipt: ").append(toIndentedString(receipt)).append("\n");
    sb.append("    createdTime: ").append(toIndentedString(createdTime)).append("\n");
    sb.append("    updatedTime: ").append(toIndentedString(updatedTime)).append("\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
    sb.append("    validityTime: ").append(toIndentedString(validityTime)).append("\n");
    sb.append("    recurringIndicator: ").append(toIndentedString(recurringIndicator)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
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