package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Response containing the status of a signing basket
 */

@Schema(name = "SigningBasketStatusResponse", description = "Response containing the status of a signing basket")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-13T04:57:51.808782492Z[Etc/UTC]")
public class SigningBasketStatusResponse {

  private String basketId;

  /**
   * The transaction status of the signing basket
   */
  public enum TransactionStatusEnum {
    RCVD("RCVD"),
    
    PATC("PATC"),
    
    ACTC("ACTC"),
    
    ACCP("ACCP"),
    
    ACSC("ACSC"),
    
    ACSP("ACSP"),
    
    PDNG("PDNG"),
    
    RJCT("RJCT"),
    
    CANC("CANC");

    private String value;

    TransactionStatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TransactionStatusEnum fromValue(String value) {
      for (TransactionStatusEnum b : TransactionStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private TransactionStatusEnum transactionStatus;

  public SigningBasketStatusResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SigningBasketStatusResponse(String basketId, TransactionStatusEnum transactionStatus) {
    this.basketId = basketId;
    this.transactionStatus = transactionStatus;
  }

  public SigningBasketStatusResponse basketId(String basketId) {
    this.basketId = basketId;
    return this;
  }

  /**
   * Identifier of the signing basket
   * @return basketId
  */
  @NotNull 
  @Schema(name = "basketId", description = "Identifier of the signing basket", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("basketId")
  public String getBasketId() {
    return basketId;
  }

  public void setBasketId(String basketId) {
    this.basketId = basketId;
  }

  public SigningBasketStatusResponse transactionStatus(TransactionStatusEnum transactionStatus) {
    this.transactionStatus = transactionStatus;
    return this;
  }

  /**
   * The transaction status of the signing basket
   * @return transactionStatus
  */
  @NotNull 
  @Schema(name = "transactionStatus", description = "The transaction status of the signing basket", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("transactionStatus")
  public TransactionStatusEnum getTransactionStatus() {
    return transactionStatus;
  }

  public void setTransactionStatus(TransactionStatusEnum transactionStatus) {
    this.transactionStatus = transactionStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SigningBasketStatusResponse signingBasketStatusResponse = (SigningBasketStatusResponse) o;
    return Objects.equals(this.basketId, signingBasketStatusResponse.basketId) &&
        Objects.equals(this.transactionStatus, signingBasketStatusResponse.transactionStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(basketId, transactionStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SigningBasketStatusResponse {\n");
    sb.append("    basketId: ").append(toIndentedString(basketId)).append("\n");
    sb.append("    transactionStatus: ").append(toIndentedString(transactionStatus)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

