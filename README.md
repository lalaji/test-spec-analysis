# test-spec-analysis

## ISO 20022 Payment Initiation Support

This repository includes support for ISO 20022 pain.001.001.03 XML schema validation for SEPA credit transfers, addressing Berlin Group compliance requirements.

For detailed information about the ISO 20022 implementation, see [ISO20022_IMPLEMENTATION.md](ISO20022_IMPLEMENTATION.md).

### Quick Start

**Validate a SEPA payment XML:**

```bash
curl -X POST http://localhost:8080/wso2-f5b/OB4/1.0.0/validate-payment-initiation \
  -H "Content-Type: application/xml" \
  -d @examples/valid-sepa-payment.xml
```

### Features

- ISO 20022 pain.001.001.03 XML schema validation
- SEPA credit transfer support
- Comprehensive error reporting
- REST API endpoint
- Sample XML files in `examples/` directory