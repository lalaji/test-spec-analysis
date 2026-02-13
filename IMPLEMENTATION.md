# Multi-Currency Account Implementation (Berlin Group REQ_0423)

## Overview

This implementation adds support for IBAN-based multi-currency account identification as required by Berlin Group specification REQ_0423:

> "An account identifier like an IBAN together with a currency always addresses uniquely a sub-account of a multicurrency account."

## Implementation Details

### API Endpoints

#### 1. Register Multi-Currency Account
- **Endpoint**: `POST /accounts/multicurrency`
- **Description**: Creates a new multi-currency account with IBAN-based identification
- **Request Body**: `RegisterMultiCurrencyAccountRequest`
  - `requestId`: Unique correlation identifier
  - `iban`: International Bank Account Number (validates ISO 13616 pattern)
  - `accountName`: Name/description of the account
  - `accountOwner`: Owner of the account
  - `supportedCurrencies`: Array of ISO 4217 currency codes
- **Response**: `MultiCurrencyAccountResponse` containing the created account with sub-accounts

#### 2. Retrieve Sub-Account by IBAN and Currency
- **Endpoint**: `GET /accounts/{iban}/{currency}`
- **Description**: Retrieves a specific sub-account uniquely identified by IBAN + currency
- **Path Parameters**:
  - `iban`: IBAN matching pattern `^[A-Z]{2}[0-9]{2}[A-Z0-9]+$`
  - `currency`: ISO 4217 currency code matching pattern `^[A-Z]{3}$`
- **Response**: `SubAccountResponse` containing the sub-account details

### Data Models

1. **MultiCurrencyAccount**: Main account with IBAN and sub-accounts
2. **SubAccount**: Currency-specific sub-account with:
   - Unique identifier: `{IBAN}-{CURRENCY}` (e.g., "DE89370400440532013000-EUR")
   - Currency code (ISO 4217)
   - Balance
   - Status (ACTIVE, INACTIVE, CLOSED)
3. **RegisterMultiCurrencyAccountRequest**: Request model for account registration
4. **MultiCurrencyAccountResponse**: Response after successful registration
5. **SubAccountResponse**: Response for sub-account retrieval

### Service Layer

**MultiCurrencyAccountServiceImpl** provides:

- **IBAN Validation**: Pattern `^[A-Z]{2}[0-9]{2}[A-Z0-9]+$` (ISO 13616 compliant)
- **Currency Validation**: Pattern `^[A-Z]{3}$` (ISO 4217 compliant)
- **Unique Account Addressing**: Each IBAN + currency combination uniquely identifies a sub-account
- **In-Memory Storage**: ConcurrentHashMap for thread-safe account management

### REQ_0423 Compliance

The implementation ensures:

1. **Uniqueness**: Each IBAN + currency combination creates a unique sub-account ID
2. **Validation**: Strict IBAN and currency format validation
3. **Addressing**: Sub-accounts can be uniquely retrieved using IBAN + currency
4. **Multi-Currency Support**: Multiple currencies per IBAN are fully supported

## Testing

Unit tests are provided in `MultiCurrencyAccountServiceImplTest.java` covering:

- Account registration
- IBAN + currency retrieval (REQ_0423)
- Validation (IBAN and currency formats)
- Error handling (invalid formats, duplicates, not found)
- Full REQ_0423 compliance flow

### Test Coverage

- ✓ Register multi-currency account
- ✓ REQ_0423: Unique sub-account identification by IBAN + currency
- ✓ IBAN validation (valid/invalid formats)
- ✓ Currency validation (ISO 4217)
- ✓ Duplicate IBAN rejection
- ✓ Sub-account not found scenarios
- ✓ Integration test for complete REQ_0423 flow

## Example Usage

### Register Account

```bash
POST /wso2-f5b/OB4/1.0.0/accounts/multicurrency
Content-Type: application/json

{
  "requestId": "REQ123",
  "iban": "DE89370400440532013000",
  "accountName": "Corporate Multi-Currency Account",
  "accountOwner": "ACME Corporation",
  "supportedCurrencies": ["EUR", "USD", "GBP"]
}
```

### Retrieve Sub-Account

```bash
GET /wso2-f5b/OB4/1.0.0/accounts/DE89370400440532013000/EUR
```

Response:
```json
{
  "iban": "DE89370400440532013000",
  "accountName": "Corporate Multi-Currency Account",
  "subAccount": {
    "currency": "EUR",
    "balance": 0.0,
    "status": "ACTIVE",
    "accountId": "DE89370400440532013000-EUR"
  }
}
```

## Files Modified/Created

### OpenAPI Specification
- `src/main/resources/openapi.yaml`: Added Account tag and two new endpoints with schemas

### Model Classes
- `src/main/java/org/openapitools/model/MultiCurrencyAccount.java`
- `src/main/java/org/openapitools/model/SubAccount.java`
- `src/main/java/org/openapitools/model/RegisterMultiCurrencyAccountRequest.java`
- `src/main/java/org/openapitools/model/MultiCurrencyAccountResponse.java`
- `src/main/java/org/openapitools/model/SubAccountResponse.java`
- `src/main/java/org/openapitools/model/ErrorResponse.java`

### API Layer
- `src/main/java/org/openapitools/api/AccountsApi.java`
- `src/main/java/org/openapitools/api/AccountsApiController.java`

### Service Layer
- `src/main/java/org/openapitools/service/MultiCurrencyAccountService.java`
- `src/main/java/org/openapitools/service/MultiCurrencyAccountServiceImpl.java`

### Tests
- `src/test/java/org/openapitools/service/MultiCurrencyAccountServiceImplTest.java`

### Configuration
- `src/main/java/org/openapitools/OpenApiGeneratorApplication.java`: Added service package to component scan

## Security Considerations

- All endpoints require OAuth2 or BasicAuth authentication
- IBAN and currency format validation prevents injection attacks
- In-memory storage is thread-safe using ConcurrentHashMap
- No sensitive data is logged

## Future Enhancements

- Persistent storage (database integration)
- Transaction support for sub-accounts
- Balance updates and transfers
- Audit trail for account operations
- Currency conversion support
