package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 * Defines the context data related to the client registration.
 */
@Schema(description = "Defines the context data related to the client registration.")
public class ClientProcessData {

  @Schema(description = "Client Registration Data. Mandatory for pre-process-client-creation and pre-process-client-update.")
  @JsonProperty("clientData")
  private Object clientData;

  @Schema(description = "Parameters of the decoded SSA. Mandatory for pre-process-client-creation, pre-process-client-update and pre-process-client-retrieval.")
  @JsonProperty("softwareStatement")
  private Object softwareStatement;

  @Schema(description = "properties of the existing client application. Mandatory for pre-process-client-update.")
  @JsonProperty("existingClientData")
  private Object existingClientData;

  /**
   * Client Registration Data. Mandatory for pre-process-client-creation and pre-process-client-update.
   * @return clientData
   */
  public Object getClientData() {
    return clientData;
  }

  public void setClientData(Object clientData) {
    this.clientData = clientData;
  }

  /**
   * Parameters of the decoded SSA. Mandatory for pre-process-client-creation, pre-process-client-update and pre-process-client-retrieval.
   * @return softwareStatement
   */
  public Object getSoftwareStatement() {
    return softwareStatement;
  }

  public void setSoftwareStatement(Object softwareStatement) {
    this.softwareStatement = softwareStatement;
  }

  /**
   * properties of the existing client application. Mandatory for pre-process-client-update.
   * @return existingClientData
   */
  public Object getExistingClientData() {
    return existingClientData;
  }

  public void setExistingClientData(Object existingClientData) {
    this.existingClientData = existingClientData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClientProcessData that = (ClientProcessData) o;
    return Objects.equals(this.clientData, that.clientData) &&
        Objects.equals(this.softwareStatement, that.softwareStatement) &&
        Objects.equals(this.existingClientData, that.existingClientData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientData, softwareStatement, existingClientData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClientProcessData {\n");
    sb.append("    clientData: ").append(toIndentedString(clientData)).append("\n");
    sb.append("    softwareStatement: ").append(toIndentedString(softwareStatement)).append("\n");
    sb.append("    existingClientData: ").append(toIndentedString(existingClientData)).append("\n");
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