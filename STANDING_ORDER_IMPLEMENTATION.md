# Standing Order Implementation - Berlin Group Compliance

## Overview

This implementation addresses the Berlin Group requirement **REQ_0705**: "The standing order MUST include structured additional information with standing order details including startDate, endDate, executionRule, frequency, and dayOfExecution."

## What Was Implemented

### 1. Data Model (`StandingOrderDetails`)

A comprehensive data model that includes all required Berlin Group fields:

#### Required Fields:
- **startDate** (LocalDate): The date on which the first payment is initiated (ISO 8601 format)
- **frequency** (Enum): Frequency of execution with values:
  - DAIL (Daily)
  - WEEK (Weekly)
  - TOWK (Twice weekly)
  - MNTH (Monthly)
  - TOMN (Twice monthly)
  - QUTR (Quarterly)
  - SEMI (Semi-annual)
  - YEAR (Annual)

#### Optional Fields:
- **endDate** (LocalDate): The date of the last payment (ISO 8601 format)
- **executionRule** (Enum): Execution rule with values:
  - ODFIND (On Due Date Find)
  - FNAL (Following Next Available)
  - PREC (Preceding Previous Available)
- **dayOfExecution** (Integer): Day of month for execution (1-31)

#### Additional Structured Information:
The model includes an `additionalInformationStructured` object containing:
- **currency**: Currency code (ISO 4217)
- **amount**: Amount for each execution
- **creditorName**: Name of the creditor
- **creditorAccount**: Creditor account details with IBAN
- **debtorAccount**: Debtor account details with IBAN
- **remittanceInformationUnstructured**: Unstructured remittance information

### 2. API Endpoints

Three RESTful endpoints were created to manage standing orders:

#### POST /standing-orders
Creates a new standing order with structured additional information.

**Request Example:**
```json
{
  "requestId": "SO123456",
  "data": {
    "standingOrderDetails": {
      "startDate": "2026-03-01",
      "endDate": "2027-03-01",
      "executionRule": "FNAL",
      "frequency": "MNTH",
      "dayOfExecution": 15,
      "additionalInformationStructured": {
        "currency": "EUR",
        "amount": 100.50,
        "creditorName": "Electricity Company",
        "creditorAccount": {
          "iban": "DE89370400440532013000"
        },
        "debtorAccount": {
          "iban": "DE40100100103307118608"
        },
        "remittanceInformationUnstructured": "Monthly payment"
      }
    }
  }
}
```

#### GET /standing-orders/{standingOrderId}
Retrieves details of a specific standing order by ID.

#### GET /standing-orders
Lists all standing orders.

### 3. Integration with Consent Model

The `StoredDetailedConsentResourceData` model was extended to include a `standingOrderDetails` field, allowing standing order information to be stored as part of the consent resource.

## Technical Implementation

### Technologies Used:
- **Spring Boot 2.7.15**: Framework for RESTful APIs
- **OpenAPI Generator 7.2.0**: For generating type-safe model classes from OpenAPI specification
- **Jakarta Validation**: For input validation with JSR-380 annotations
- **Jackson**: For JSON serialization/deserialization

### Code Structure:
- **API Interface**: `StandingOrdersApi.java` - Defines the contract for standing order operations
- **Controller**: `StandingOrdersApiController.java` - Implements the API endpoints
- **Models**: Auto-generated from OpenAPI specification
  - `StandingOrderDetails.java`
  - `StandingOrderCreationRequest.java`
  - `StandingOrderCreationResponse.java`
  - `StandingOrderResponse.java`
  - `StandingOrderListResponse.java`

### Build Configuration:
The `pom.xml` was updated to include the OpenAPI Generator Maven plugin, which automatically generates model classes during the build process from the OpenAPI specification.

## Compliance

This implementation fully satisfies the Berlin Group requirement REQ_0705:

✅ **startDate**: Mandatory field with ISO 8601 date format
✅ **endDate**: Optional field with ISO 8601 date format
✅ **executionRule**: Optional field with Berlin Group standard values (ODFIND, FNAL, PREC)
✅ **frequency**: Mandatory field with Berlin Group standard frequency codes
✅ **dayOfExecution**: Optional field with validation for days 1-31
✅ **additionalInformationStructured**: Comprehensive structured information for standing order details

## API Documentation

The implementation includes comprehensive OpenAPI documentation with:
- Detailed descriptions for all fields
- Request/response examples
- Schema validation rules
- Security requirements (OAuth2 and BasicAuth)

## Usage

To use the standing order functionality:

1. **Build the project**:
   ```bash
   mvn clean compile
   ```

2. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

3. **Access API documentation**:
   Navigate to `http://localhost:8080/swagger-ui.html` (when running)

## Extension Points

The implementation provides extension points for:
- Custom validation logic in the controller
- Business logic for standing order creation and management
- Integration with payment processing systems
- Storage and retrieval from backend databases

## Future Enhancements

Potential enhancements could include:
- Standing order cancellation endpoint
- Standing order modification endpoint
- Execution history tracking
- Notification mechanisms for failed executions
- Bulk standing order operations
