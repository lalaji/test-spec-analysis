package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class SuccessResponsePopulateConsentAuthorizeScreenData {

  @Schema(description = "")
  @JsonProperty("consentData")
  private SuccessResponsePopulateConsentAuthorizeScreenData_consentData consentData;

  @Schema(description = "")
  @JsonProperty("consumerData")
  private SuccessResponsePopulateConsentAuthorizeScreenData_consumerData consumerData;

  /**
   * 
   * @return consentData
   */
  public SuccessResponsePopulateConsentAuthorizeScreenData_consentData getConsentData() {
    return consentData;
  }

  public void setConsentData(SuccessResponsePopulateConsentAuthorizeScreenData_consentData consentData) {
    this.consentData = consentData;
  }

  /**
   * 
   * @return consumerData
   */
  public SuccessResponsePopulateConsentAuthorizeScreenData_consumerData getConsumerData() {
    return consumerData;
  }

  public void setConsumerData(SuccessResponsePopulateConsentAuthorizeScreenData_consumerData consumerData) {
    this.consumerData = consumerData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponsePopulateConsentAuthorizeScreenData that = (SuccessResponsePopulateConsentAuthorizeScreenData) o;
    return Objects.equals(this.consentData, that.consentData) &&
        Objects.equals(this.consumerData, that.consumerData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentData, consumerData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponsePopulateConsentAuthorizeScreenData {\n");
    sb.append("    consentData: ").append(toIndentedString(consentData)).append("\n");
    sb.append("    consumerData: ").append(toIndentedString(consumerData)).append("\n");
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