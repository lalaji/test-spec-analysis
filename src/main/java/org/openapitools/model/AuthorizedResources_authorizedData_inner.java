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
public class AuthorizedResources_authorizedData_inner {

  @Schema(description = "Granted permissions (optional if no permissions exist)")
  @JsonProperty("permissions")
  private List<String> permissions;

  @Schema(description = "Accounts selected for the permissions")
  @JsonProperty("accounts")
  @NotNull
  private List<Account> accounts;

  /**
   * Granted permissions (optional if no permissions exist)
   * @return permissions
   */
  public List<String> getPermissions() {
    return permissions;
  }

  public void setPermissions(List<String> permissions) {
    this.permissions = permissions;
  }

  /**
   * Accounts selected for the permissions
   * @return accounts
   */
  public List<Account> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<Account> accounts) {
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
    AuthorizedResources_authorizedData_inner that = (AuthorizedResources_authorizedData_inner) o;
    return Objects.equals(this.permissions, that.permissions) &&
        Objects.equals(this.accounts, that.accounts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(permissions, accounts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthorizedResources_authorizedData_inner {\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
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