package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Consumer related data fetched from the banking backend.
 */
@Schema(description = "Consumer related data fetched from the banking backend.")
public class SuccessResponsePopulateConsentAuthorizeScreenData_consumerData {

  @Schema(description = "List of all user accounts/resources selectable in the UI")
  @JsonProperty("accounts")
  private List<SuccessResponsePopulateConsentAuthorizeScreenData_consumerData_accounts_inner> accounts;

  /**
   * List of all user accounts/resources selectable in the UI
   * @return accounts
   */
  public List<SuccessResponsePopulateConsentAuthorizeScreenData_consumerData_accounts_inner> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<SuccessResponsePopulateConsentAuthorizeScreenData_consumerData_accounts_inner> accounts) {
    this.accounts = accounts;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponsePopulateConsentAuthorizeScreenData_consumerData that = (SuccessResponsePopulateConsentAuthorizeScreenData_consumerData) o;
    return Objects.equals(this.accounts, that.accounts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accounts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponsePopulateConsentAuthorizeScreenData_consumerData {\n");
    sb.append("    accounts: ").append(toIndentedString(accounts)).append("\n");
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