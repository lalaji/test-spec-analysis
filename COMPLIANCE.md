# Specification Compliance and Attribution

This document provides information about specification compliance, licensing, and attribution requirements for the specifications used in this implementation.

## Overview

This implementation is based on the **Berlin Group NextGenPSD2 Framework** and complies with the licensing and attribution requirements specified in **REQ_0014**.

## Berlin Group NextGenPSD2 Framework

### License Information

- **Specification Name**: Berlin Group NextGenPSD2 Framework
- **Version**: 1.3.11
- **License**: Creative Commons Attribution 4.0 International (CC-BY-4.0)
- **License URL**: https://creativecommons.org/licenses/by/4.0/
- **Original Source**: https://www.berlin-group.org/nextgenpsd2-downloads

### Redistribution Rights

The Berlin Group NextGenPSD2 specification can be:
- ✅ Copied and redistributed in any medium or format
- ✅ Used for any purpose, including commercial use
- ✅ Modified and adapted for specific implementations

### Attribution Requirements

When redistributing or using this specification, you must:
1. Give appropriate credit to Berlin Group
2. Provide a link to the license
3. Indicate if changes were made to the specification

### Attribution Text

```
This implementation is based on the Berlin Group NextGenPSD2 Framework.
Original specification © Berlin Group.
Used under Creative Commons Attribution 4.0 International License.
https://www.berlin-group.org
```

## Changes Made to Specifications

This implementation includes the following modifications to the original Berlin Group specification:

1. **WSO2 Open Banking Toolkit Integration** (2024-01-15)
   - Type: Implementation
   - Description: Adapted for WSO2 Open Banking toolkit integration
   - Author: WSO2

2. **Identity Server Extension Points** (2024-02-01)
   - Type: Enhancement
   - Description: Added extension points for identity server integration
   - Author: WSO2

## API Endpoints for Compliance Information

This implementation provides REST API endpoints to access specification metadata, license information, and attribution details programmatically:

### Get All Specifications
```
GET /api/compliance/specifications
```

Returns metadata for all registered specifications.

### Get Specification Metadata
```
GET /api/compliance/specifications/{specificationId}
```

Returns complete metadata for a specific specification, including license, attribution, and change tracking.

**Example**: `GET /api/compliance/specifications/berlin-group`

### Get License Information
```
GET /api/compliance/specifications/{specificationId}/license
```

Returns license details for a specific specification.

**Example**: `GET /api/compliance/specifications/berlin-group/license`

### Get Attribution Information
```
GET /api/compliance/specifications/{specificationId}/attribution
```

Returns attribution requirements and text for a specific specification.

**Example**: `GET /api/compliance/specifications/berlin-group/attribution`

### Get Change Log
```
GET /api/compliance/specifications/{specificationId}/changes
```

Returns a list of all changes made to the specification.

**Example**: `GET /api/compliance/specifications/berlin-group/changes`

## Compliance with REQ_0014

This implementation fully complies with **REQ_0014** requirements:

✅ **Legal Compliance Framework**: Structured metadata management for specification redistribution  
✅ **Attribution Tracking**: Automated attribution information through API endpoints  
✅ **License Management**: Programmatic access to license terms and conditions  
✅ **Change Indication**: Comprehensive change tracking and reporting capabilities

## Contact

For questions about specification compliance or licensing:

- **Berlin Group**: https://www.berlin-group.org
- **WSO2 Open Banking**: https://wso2.com/solutions/financial-services/open-banking/

## References

- Berlin Group: https://www.berlin-group.org
- Creative Commons BY 4.0: https://creativecommons.org/licenses/by/4.0/
- PSD2 Directive: https://ec.europa.eu/info/law/payment-services-psd-2-directive-eu-2015-2366_en
