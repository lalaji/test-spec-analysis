# ISO 20022 Payment Initiation Support

This document describes the ISO 20022 pain.001.001.03 XML schema validation support added to the WSO2 Open Banking toolkit for SEPA credit transfers.

## Overview

The implementation provides XML schema validation for SEPA credit transfer payment initiation requests conforming to ISO 20022 pain.001.001.03 standard, as required by the Berlin Group specification.

## Features

- **XML Schema Validation**: Validates payment initiation XML against ISO 20022 pain.001.001.03 XSD schema
- **SEPA Credit Transfer Support**: Full support for SEPA credit transfer message format
- **Comprehensive Error Reporting**: Detailed validation errors with line numbers
- **REST API Integration**: Standard REST endpoint for payment validation
- **Standard Response Format**: Consistent with existing WSO2 API response structure

## API Endpoint

### POST /wso2-f5b/OB4/1.0.0/validate-payment-initiation

Validates a SEPA credit transfer payment initiation XML document.

**Request:**
- **Content-Type**: `application/xml` or `text/xml`
- **Body**: ISO 20022 pain.001.001.03 XML document

**Response:**
- **Content-Type**: `application/json`
- **Status Codes**:
  - 200 OK - Validation completed (check `data.valid` field)
  - 400 Bad Request - Invalid request
  - 500 Internal Server Error - Server error

**Response Format:**
```json
{
  "responseId": "uuid",
  "status": "SUCCESS",
  "data": {
    "valid": true,
    "validationErrors": [],
    "schema": "ISO 20022 pain.001.001.03"
  },
  "errorCode": null,
  "errorMessage": null
}
```

## Sample Valid XML

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Document xmlns="urn:iso:std:iso:20022:tech:xsd:pain.001.001.03">
  <CstmrCdtTrfInitn>
    <GrpHdr>
      <MsgId>MSG-20240101-001</MsgId>
      <CreDtTm>2024-01-01T10:00:00</CreDtTm>
      <NbOfTxs>1</NbOfTxs>
      <InitgPty>
        <Nm>ACME Corporation</Nm>
      </InitgPty>
    </GrpHdr>
    <PmtInf>
      <PmtInfId>PMT-20240101-001</PmtInfId>
      <PmtMtd>TRF</PmtMtd>
      <ReqdExctnDt>2024-01-02</ReqdExctnDt>
      <Dbtr>
        <Nm>ACME Corporation</Nm>
        <PstlAdr>
          <Ctry>DE</Ctry>
          <AdrLine>123 Business Street</AdrLine>
        </PstlAdr>
      </Dbtr>
      <DbtrAcct>
        <Id>
          <IBAN>DE89370400440532013000</IBAN>
        </Id>
      </DbtrAcct>
      <DbtrAgt>
        <FinInstnId>
          <BIC>COBADEFFXXX</BIC>
        </FinInstnId>
      </DbtrAgt>
      <CdtTrfTxInf>
        <PmtId>
          <EndToEndId>E2E-20240101-001</EndToEndId>
        </PmtId>
        <Amt>
          <InstdAmt Ccy="EUR">1250.00</InstdAmt>
        </Amt>
        <CdtrAgt>
          <FinInstnId>
            <BIC>SOGEDEFFXXX</BIC>
          </FinInstnId>
        </CdtrAgt>
        <Cdtr>
          <Nm>Supplier Company Ltd</Nm>
          <PstlAdr>
            <Ctry>FR</Ctry>
            <AdrLine>456 Commerce Avenue</AdrLine>
          </PstlAdr>
        </Cdtr>
        <CdtrAcct>
          <Id>
            <IBAN>FR1420041010050500013M02606</IBAN>
          </Id>
        </CdtrAcct>
        <RmtInf>
          <Ustrd>Payment for invoice INV-2024-001</Ustrd>
        </RmtInf>
      </CdtTrfTxInf>
    </PmtInf>
  </CstmrCdtTrfInitn>
</Document>
```

## Implementation Details

### Components

1. **ISO20022ValidationService** (`org.openapitools.service.ISO20022ValidationService`)
   - Core validation logic using JAXB and XML Schema validation
   - Validates XML structure against pain.001.001.03 XSD
   - Returns detailed validation results with error messages

2. **ValidatePaymentInitiationController** (`org.openapitools.api.ValidatePaymentInitiationController`)
   - REST controller exposing the validation endpoint
   - Handles XML to JSON response conversion
   - Provides consistent error handling

3. **PaymentValidationResponse** (`org.openapitools.model.PaymentValidationResponse`)
   - Response model matching WSO2 API response format
   - Contains validation results and error details

4. **XSD Schema** (`/schemas/pain.001.001.03.xsd`)
   - ISO 20022 pain.001.001.03 XML Schema Definition
   - Defines structure for SEPA credit transfers

### Dependencies Added

```xml
<!-- XML Processing for ISO 20022 -->
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
</dependency>
<dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
    <version>2.3.1</version>
</dependency>
<dependency>
    <groupId>org.glassfish.jaxb</groupId>
    <artifactId>jaxb-runtime</artifactId>
</dependency>
```

## Validation Rules

The validator checks:
- **XML Well-formedness**: Valid XML syntax
- **Namespace**: Correct ISO 20022 namespace (`urn:iso:std:iso:20022:tech:xsd:pain.001.001.03`)
- **Schema Compliance**: All mandatory elements present
- **Data Format**: IBAN, BIC, currency codes match patterns
- **Structure**: Proper nesting and element sequence

## Usage Example

### cURL Request

```bash
curl -X POST http://localhost:8080/wso2-f5b/OB4/1.0.0/validate-payment-initiation \
  -H "Content-Type: application/xml" \
  -d @payment.xml
```

### Sample Response (Valid XML)

```json
{
  "responseId": "f47ac10b-58cc-4372-a567-0e02b2c3d479",
  "status": "SUCCESS",
  "data": {
    "valid": true,
    "validationErrors": [],
    "schema": "ISO 20022 pain.001.001.03"
  }
}
```

### Sample Response (Invalid XML)

```json
{
  "responseId": "f47ac10b-58cc-4372-a567-0e02b2c3d480",
  "status": "SUCCESS",
  "data": {
    "valid": false,
    "validationErrors": [
      "Error at line 5: Element 'InvalidElement' is not allowed",
      "Error at line 10: Missing required element 'CreDtTm'"
    ],
    "schema": "ISO 20022 pain.001.001.03"
  }
}
```

## Testing

Unit tests are provided for:
- ISO20022ValidationService (service layer tests)
- ValidatePaymentInitiationController (API controller tests)

Run tests with:
```bash
mvn test
```

## Configuration

No additional configuration is required. The validator uses the embedded XSD schema file and is automatically registered as a Spring bean.

## Compliance

This implementation addresses the Berlin Group compliance requirement:
- **Requirement ID**: REQ_0249
- **Gap ID**: gap_0249
- **Requirement**: Payment initiation request body MUST conform to ISO 20022 pain.001.001.03 XML schema for SEPA credit transfers

## References

- [ISO 20022 Standard](https://www.iso20022.org/)
- [pain.001.001.03 Message Definition](https://www.iso20022.org/catalogue-messages/iso-20022-messages-archive?search=pain.001.001.03)
- [Berlin Group NextGenPSD2 Framework](https://www.berlin-group.org/)
