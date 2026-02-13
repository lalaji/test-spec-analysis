# PSU-GEO-Location Header Implementation

## Overview

This implementation adds support for the PSU-GEO-Location header validation in compliance with Berlin Group specifications for Open Banking APIs. The PSU-GEO-Location header contains the geographical coordinates of the Payment Service User (PSU) and is required for signing basket requests and consent operations.

## Compliance Gap Addressed

**Gap ID:** `gap_1117`  
**Requirement ID:** `REQ_1117`  
**Specification:** Berlin Group  
**Requirement:** Signing basket request SHOULD include PSU-GEO-Location header with geographical coordinates  
**Capability:** Customer Authentication (SCA)

## Components Implemented

### 1. GeoLocationValidator

**Location:** `src/main/java/org/openapitools/validation/GeoLocationValidator.java`

A utility class that validates geographical coordinates according to Berlin Group specifications.

**Format:** `GEO:latitude;longitude`
- Latitude: -90 to 90 degrees
- Longitude: -180 to 180 degrees
- Case insensitive prefix

**Example valid values:**
```
GEO:52.506931;13.144558  (Berlin, Germany)
GEO:51.507351;-0.127758  (London, UK)
GEO:40.712776;-74.005974 (New York, USA)
```

**Methods:**
- `isValid(String geoLocation)` - Returns true if the format and coordinates are valid
- `getValidationError(String geoLocation)` - Returns a descriptive error message for invalid input

### 2. PSUGeoLocationHeaderValidator

**Location:** `src/main/java/org/openapitools/validation/PSUGeoLocationHeaderValidator.java`

A Spring component that provides header validation services for consent and signing basket requests.

**Methods:**
- `validateHeader(String psuGeoLocation)` - Strict validation (throws exception if invalid)
- `validateSigningBasketHeader(String psuGeoLocation)` - Lenient validation for SHOULD requirement
- `getValidationErrorMessage(String psuGeoLocation)` - Returns error message without throwing

### 3. PSUGeoLocationInterceptor

**Location:** `src/main/java/org/openapitools/interceptor/PSUGeoLocationInterceptor.java`

A Spring HandlerInterceptor that automatically validates PSU-GEO-Location headers for relevant endpoints.

**Validated Endpoints:**
- `/pre-process-consent-creation`
- `/validate-consent-access`
- `/signing-basket/**`
- `/persist-authorized-consent`

**Behavior:**
- For signing basket requests: Validation only if header is provided (SHOULD requirement)
- For other consent operations: Strict validation (MUST requirement)
- Returns 400 Bad Request with detailed error message for invalid headers

### 4. WebMvcConfiguration

**Location:** `src/main/java/org/openapitools/configuration/WebMvcConfiguration.java`

Spring MVC configuration that registers the PSU-GEO-Location interceptor.

## Usage Examples

### Adding PSU-GEO-Location Header to API Requests

```bash
curl -X POST https://api.bank.com/pre-process-consent-creation \
  -H "Content-Type: application/json" \
  -H "PSU-Geo-Location: GEO:52.506931;13.144558" \
  -d '{"requestId": "123", "data": {...}}'
```

### Programmatic Validation

```java
import org.openapitools.validation.GeoLocationValidator;

// Validate coordinates
String geoLocation = "GEO:52.506931;13.144558";
if (GeoLocationValidator.isValid(geoLocation)) {
    // Process request
} else {
    String error = GeoLocationValidator.getValidationError(geoLocation);
    // Handle error
}
```

### Using the Spring Component

```java
@Autowired
private PSUGeoLocationHeaderValidator validator;

public void processConsentRequest(String psuGeoLocation) {
    try {
        validator.validateHeader(psuGeoLocation);
        // Continue processing
    } catch (IllegalArgumentException e) {
        // Handle validation error
        log.error("Invalid PSU-GEO-Location: {}", e.getMessage());
    }
}
```

## Test Coverage

Comprehensive unit tests are provided:

### GeoLocationValidatorTest
**Location:** `src/test/java/org/openapitools/validation/GeoLocationValidatorTest.java`

**Test Cases:**
- Valid geographical coordinates (including real-world locations)
- Invalid format (missing prefix, wrong separator, etc.)
- Invalid latitude/longitude ranges
- Boundary value testing
- Error message generation

### PSUGeoLocationHeaderValidatorTest
**Location:** `src/test/java/org/openapitools/validation/PSUGeoLocationHeaderValidatorTest.java`

**Test Cases:**
- Successful validation
- Null and empty header handling
- Invalid format exception handling
- Signing basket SHOULD requirement behavior
- Error message retrieval

### Running Tests

```bash
# Run all validation tests
mvn test -Dtest=*Validator*Test

# Run specific test class
mvn test -Dtest=GeoLocationValidatorTest

# Manual verification
javac -cp target/classes -d target/classes src/main/java/org/openapitools/validation/GeoLocationValidatorManualTest.java
java -cp target/classes org.openapitools.validation.GeoLocationValidatorManualTest
```

## Error Responses

When validation fails, the interceptor returns a 400 Bad Request response:

```json
{
  "status": "ERROR",
  "errorMessage": "invalid_header",
  "errorDescription": "PSU-GEO-Location header must be in format 'GEO:latitude;longitude'"
}
```

**Common error messages:**
- "PSU-GEO-Location header is required and cannot be empty"
- "PSU-GEO-Location header must start with 'GEO:' prefix"
- "PSU-GEO-Location header must be in format 'GEO:latitude;longitude'"
- "Latitude must be between -90 and 90 degrees"
- "Longitude must be between -180 and 180 degrees"

## Configuration

The interceptor is automatically configured via `WebMvcConfiguration`. No additional configuration is required.

To disable the interceptor for specific endpoints, modify `WebMvcConfiguration`:

```java
@Override
public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(psuGeoLocationInterceptor)
            .addPathPatterns("/pre-process-consent-creation")
            .excludePathPatterns("/health", "/metrics");
}
```

## Berlin Group Compliance

This implementation addresses the Berlin Group requirement:

> "Signing basket request SHOULD include PSU-GEO-Location header with geographical coordinates"

**Key Features:**
✅ GEO coordinate format compliance checking  
✅ PSU-GEO-Location header handling  
✅ Geographical coordinate format validation  
✅ Basket request signing with location headers  

**Compliance Level:**
- Signing basket requests: SHOULD (recommended but not mandatory)
- Consent creation/access: Can be configured as MUST or SHOULD based on requirements

## Integration with WSO2 Open Banking Toolkit

This implementation integrates seamlessly with the WSO2 Open Banking accelerator extension framework:

1. **Interceptor-based validation** - Non-invasive validation without modifying generated API code
2. **Spring component architecture** - Follows WSO2 toolkit patterns
3. **Error response format** - Matches existing accelerator error format
4. **Configurable endpoints** - Easy to add/remove validated endpoints

## Future Enhancements

Potential improvements for future versions:

1. **IP Geolocation fallback** - Validate IP-based geolocation as alternative format
2. **Geofencing** - Validate coordinates are within allowed geographical boundaries
3. **Audit logging** - Log all PSU locations for compliance reporting
4. **Configuration properties** - Externalize validation rules via application.properties
5. **Custom validation rules** - Support bank-specific geographical restrictions

## Dependencies

No additional dependencies are required. The implementation uses:
- Java 8+ standard library (Pattern, regex)
- Spring Boot 2.7.15 (already in project)
- Spring Web MVC (already in project)
- JUnit 5 (for tests, already in project)

## Troubleshooting

### Issue: Interceptor not triggering
**Solution:** Ensure `WebMvcConfiguration` is in a package scanned by Spring (`org.openapitools.configuration`)

### Issue: Validation too strict for signing baskets
**Solution:** Use `validateSigningBasketHeader()` method which allows missing headers

### Issue: Custom error response format needed
**Solution:** Modify `sendErrorResponse()` in `PSUGeoLocationInterceptor`

## Support

For questions or issues:
1. Check test cases for usage examples
2. Review JavaDoc comments in validator classes
3. Verify header format matches: `GEO:latitude;longitude`

## License

This implementation follows the Apache 2.0 license of the WSO2 Open Banking toolkit.
