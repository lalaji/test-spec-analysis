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
public class SuccessResponsePopulateConsentAuthorizeScreenData_consentData {

  @Schema(description = "The type of consent")
  @JsonProperty("type")
  private String type;

  @Schema(description = "Structured descriptive text shown on the consent page, split into sections. Each key is a section title, and its value is a list of bullet points displayed under that section.")
  @JsonProperty("basicConsentData")
  private Object basicConsentData;

  @Schema(description = "List of permissions for the consent (optional)")
  @JsonProperty("permissions")
  private List<SuccessResponsePopulateConsentAuthorizeScreenData_consentData_permissions_inner> permissions;

  @Schema(description = "Initialized accounts for the overall consent (optional)")
  @JsonProperty("initiatedAccountsForConsent")
  private List<Account> initiatedAccountsForConsent;

  @Schema(description = "Indicates if multiple consumer accounts can be selected per consent / permission")
  @JsonProperty("allowMultipleAccounts")
  private Boolean allowMultipleAccounts;

  @Schema(description = "Indicates if account selection must be handled separately in the UI")
  @JsonProperty("handleAccountSelectionSeparately")
  private Boolean handleAccountSelectionSeparately;

  @Schema(description = "Indicates if this is a reauthorization flow (optional)")
  @JsonProperty("isReauthorization")
  private Boolean isReauthorization;

  @Schema(description = "Hidden consent metadata to be forwarded to consent persistence.")
  @JsonProperty("consentMetadata")
  private Object consentMetadata;

  /**
   * The type of consent
   * @return type
   */
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  /**
   * Structured descriptive text shown on the consent page, split into sections. Each key is a section title, and its value is a list of bullet points displayed under that section.
   * @return basicConsentData
   */
  public Object getBasicConsentData() {
    return basicConsentData;
  }

  public void setBasicConsentData(Object basicConsentData) {
    this.basicConsentData = basicConsentData;
  }

  /**
   * List of permissions for the consent (optional)
   * @return permissions
   */
  public List<SuccessResponsePopulateConsentAuthorizeScreenData_consentData_permissions_inner> getPermissions() {
    return permissions;
  }

  public void setPermissions(List<SuccessResponsePopulateConsentAuthorizeScreenData_consentData_permissions_inner> permissions) {
    this.permissions = permissions;
  }

  /**
   * Initialized accounts for the overall consent (optional)
   * @return initiatedAccountsForConsent
   */
  public List<Account> getInitiatedAccountsForConsent() {
    return initiatedAccountsForConsent;
  }

  public void setInitiatedAccountsForConsent(List<Account> initiatedAccountsForConsent) {
    this.initiatedAccountsForConsent = initiatedAccountsForConsent;
  }

  /**
   * Indicates if multiple consumer accounts can be selected per consent / permission
   * @return allowMultipleAccounts
   */
  public Boolean getAllowMultipleAccounts() {
    return allowMultipleAccounts;
  }

  public void setAllowMultipleAccounts(Boolean allowMultipleAccounts) {
    this.allowMultipleAccounts = allowMultipleAccounts;
  }

  /**
   * Indicates if account selection must be handled separately in the UI
   * @return handleAccountSelectionSeparately
   */
  public Boolean getHandleAccountSelectionSeparately() {
    return handleAccountSelectionSeparately;
  }

  public void setHandleAccountSelectionSeparately(Boolean handleAccountSelectionSeparately) {
    this.handleAccountSelectionSeparately = handleAccountSelectionSeparately;
  }

  /**
   * Indicates if this is a reauthorization flow (optional)
   * @return isReauthorization
   */
  public Boolean getIsReauthorization() {
    return isReauthorization;
  }

  public void setIsReauthorization(Boolean isReauthorization) {
    this.isReauthorization = isReauthorization;
  }

  /**
   * Hidden consent metadata to be forwarded to consent persistence.
   * @return consentMetadata
   */
  public Object getConsentMetadata() {
    return consentMetadata;
  }

  public void setConsentMetadata(Object consentMetadata) {
    this.consentMetadata = consentMetadata;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponsePopulateConsentAuthorizeScreenData_consentData that = (SuccessResponsePopulateConsentAuthorizeScreenData_consentData) o;
    return Objects.equals(this.type, that.type) &&
        Objects.equals(this.basicConsentData, that.basicConsentData) &&
        Objects.equals(this.permissions, that.permissions) &&
        Objects.equals(this.initiatedAccountsForConsent, that.initiatedAccountsForConsent) &&
        Objects.equals(this.allowMultipleAccounts, that.allowMultipleAccounts) &&
        Objects.equals(this.handleAccountSelectionSeparately, that.handleAccountSelectionSeparately) &&
        Objects.equals(this.isReauthorization, that.isReauthorization) &&
        Objects.equals(this.consentMetadata, that.consentMetadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, basicConsentData, permissions, initiatedAccountsForConsent, allowMultipleAccounts, handleAccountSelectionSeparately, isReauthorization, consentMetadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponsePopulateConsentAuthorizeScreenData_consentData {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    basicConsentData: ").append(toIndentedString(basicConsentData)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("    initiatedAccountsForConsent: ").append(toIndentedString(initiatedAccountsForConsent)).append("\n");
    sb.append("    allowMultipleAccounts: ").append(toIndentedString(allowMultipleAccounts)).append("\n");
    sb.append("    handleAccountSelectionSeparately: ").append(toIndentedString(handleAccountSelectionSeparately)).append("\n");
    sb.append("    isReauthorization: ").append(toIndentedString(isReauthorization)).append("\n");
    sb.append("    consentMetadata: ").append(toIndentedString(consentMetadata)).append("\n");
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