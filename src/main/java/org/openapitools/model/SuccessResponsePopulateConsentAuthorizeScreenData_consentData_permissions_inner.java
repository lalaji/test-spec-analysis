package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.NotNull;

/**
 */
@Schema(description = "")
public class SuccessResponsePopulateConsentAuthorizeScreenData_consentData_permissions_inner {

  @Schema(description = "Unique ID for the permission")
  @JsonProperty("uid")
  @NotNull
  private String uid;

  @Schema(description = "Permission display values")
  @JsonProperty("displayValues")
  @NotNull
  private List<String> displayValues;

  @Schema(description = "Accounts initiated with this permission")
  @JsonProperty("initiatedAccounts")
  private List<Account> initiatedAccounts;

  /**
   * Unique ID for the permission
   * @return uid
   */
  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  /**
   * Permission display values
   * @return displayValues
   */
  public List<String> getDisplayValues() {
    return displayValues;
  }

  public void setDisplayValues(List<String> displayValues) {
    this.displayValues = displayValues;
  }

  /**
   * Accounts initiated with this permission
   * @return initiatedAccounts
   */
  public List<Account> getInitiatedAccounts() {
    return initiatedAccounts;
  }

  public void setInitiatedAccounts(List<Account> initiatedAccounts) {
    this.initiatedAccounts = initiatedAccounts;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponsePopulateConsentAuthorizeScreenData_consentData_permissions_inner that = (SuccessResponsePopulateConsentAuthorizeScreenData_consentData_permissions_inner) o;
    return Objects.equals(this.uid, that.uid) &&
        Objects.equals(this.displayValues, that.displayValues) &&
        Objects.equals(this.initiatedAccounts, that.initiatedAccounts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uid, displayValues, initiatedAccounts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponsePopulateConsentAuthorizeScreenData_consentData_permissions_inner {\n");
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
    sb.append("    displayValues: ").append(toIndentedString(displayValues)).append("\n");
    sb.append("    initiatedAccounts: ").append(toIndentedString(initiatedAccounts)).append("\n");
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