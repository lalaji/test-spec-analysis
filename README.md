# test-spec-analysis

## Overview
This project is a Spring Boot application that implements the API contract for financial accelerator extension points in WSO2 IS and APIM. It provides various extension points for Open Banking functionality including consent management, client registration, and card account operations.

## Berlin Group Card Accounts API Support

This project now includes support for the Berlin Group specification card accounts API (REQ_0770).

### Card Accounts Endpoint

#### GET /v1/card-accounts/{account-id}/transactions

Retrieve transaction list for a specific card account. This endpoint supports the Berlin Group specification requirement for accessing card account transaction data.

**Parameters:**
- `account-id` (path, required): The unique identifier of the card account
- `dateFrom` (query, optional): Starting date for transactions in YYYY-MM-DD format
- `dateTo` (query, optional): End date for transactions in YYYY-MM-DD format
- `bookingStatus` (query, optional): Filter transactions by booking status (`booked`, `pending`, or `both`). Default: `both`

**Example Request:**
```bash
GET /v1/card-accounts/3dc3d5b3-7023-4848-9853-f5400a64e80f/transactions?dateFrom=2024-01-01&dateTo=2024-12-31&bookingStatus=both
```

**Example Response:**
```json
{
  "cardAccountId": "3dc3d5b3-7023-4848-9853-f5400a64e80f",
  "transactions": {
    "booked": [
      {
        "transactionId": "TXN-BOOKED-001",
        "transactionAmount": {
          "currency": "EUR",
          "amount": "256.67"
        },
        "bookingDate": "2024-01-15",
        "valueDate": "2024-01-15",
        "creditorName": "Grocery Store",
        "merchantCategoryCode": "5411",
        "transactionDetails": "Grocery purchase"
      }
    ],
    "pending": [
      {
        "transactionId": "TXN-PENDING-001",
        "transactionAmount": {
          "currency": "EUR",
          "amount": "125.00"
        },
        "creditorName": "Restaurant",
        "merchantCategoryCode": "5812",
        "transactionDetails": "Dinner"
      }
    ]
  }
}
```

**Response Codes:**
- `200` - Successful response with card account transactions
- `400` - Bad Request - Invalid parameters
- `401` - Unauthorized - Invalid or missing credentials
- `403` - Forbidden - Insufficient permissions
- `404` - Not Found - Card account not found
- `500` - Internal Server Error

## Building the Project

The project uses Maven and OpenAPI Generator to generate API interfaces and models from the OpenAPI specification.

### Prerequisites
- Java 8 or higher
- Maven 3.6 or higher

### Build Commands

```bash
# Clean and compile
mvn clean compile

# Package (create JAR)
mvn package

# Run the application
mvn spring-boot:run
```

## OpenAPI Specification

The API is defined in `src/main/resources/openapi.yaml`. Any changes to the API specification require regenerating the code:

```bash
mvn clean generate-sources
```

This will regenerate:
- API interfaces in `target/generated-sources/openapi/src/main/java/org/openapitools/api/`
- Model classes in `target/generated-sources/openapi/src/main/java/org/openapitools/model/`

## Implementation

The card accounts API is implemented in `CardAccountsApiDelegateImpl.java`, which provides sample transaction data. For production use, this implementation should be extended to integrate with actual banking backend systems.

## Extension Points

This project provides extension points for:
- Client registration and management
- Application lifecycle
- Consent flow operations
- Token issuance
- Authorization validation
- Error handling
- Card account operations (Berlin Group compliance)

For more information about WSO2 Open Banking, visit: https://wso2.com/solutions/financial-services/open-banking/
