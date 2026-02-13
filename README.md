# test-spec-analysis

WSO2 Open Banking Toolkit with Berlin Group Specification Compliance

## Overview

This project implements the WSO2 Open Banking accelerator with full support for Berlin Group specification requirements, including REQ_0014 compliance for specification redistribution.

## Berlin Group REQ_0014 Compliance

This implementation includes complete support for REQ_0014 - legal/licensing terms for specification redistribution:

✅ **License Management** - Proper license information (CC BY 4.0)  
✅ **Attribution Tracking** - Required attribution and credit  
✅ **Change Indication** - Full change tracking for redistributed specifications  
✅ **Legal Compliance Framework** - Automated compliance verification

See [COMPLIANCE_REQ_0014.md](COMPLIANCE_REQ_0014.md) for detailed documentation.

### Quick Start

```bash
# Build the project
mvn clean install

# Run tests
mvn test

# Start the application
mvn spring-boot:run
```

### API Endpoints

- `GET /api/specification/metadata` - Get specification metadata
- `GET /api/specification/license` - Get license information
- `GET /api/specification/attribution` - Get attribution text
- `GET /api/specification/changes` - List specification changes
- `POST /api/specification/changes` - Record a change
- `GET /api/specification/compliance/verify` - Verify REQ_0014 compliance

## Features

- **Specification License Management**: Complete license and attribution tracking
- **Change Tracking**: Audit trail for all specification modifications
- **Compliance Verification**: Automated REQ_0014 compliance checking
- **REST API**: Easy integration with existing systems
- **Fully Tested**: Comprehensive unit test coverage

## Requirements

- Java 8 or higher
- Maven 3.6 or higher
- Spring Boot 2.7.15

## License

This implementation includes the Berlin Group Open Banking API Specification, licensed under Creative Commons Attribution 4.0 International (CC BY 4.0).

Original source: Berlin Group  
License URL: https://creativecommons.org/licenses/by/4.0/

This specification can be copied and redistributed in any medium or format for any purpose, even commercially. When shared, appropriate credit must be given, a link to the license must be provided, and changes must be indicated.