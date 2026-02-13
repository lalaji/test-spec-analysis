# Configuration Guide for _links Field

## Overview

This guide provides detailed information on configuring the `_links` field behavior in your WSO2 Open Banking implementation to comply with Berlin Group requirement REQ_1108.

## Configuration Properties

### Link Format Configuration

The primary configuration for link formatting is controlled through the `application.properties` file.

#### openbanking.links.format

**Property**: `openbanking.links.format`  
**Type**: String  
**Valid Values**: `RELATIVE`, `ABSOLUTE`  
**Default**: `RELATIVE`  
**Required**: No

Determines whether links in the `_links` field are rendered as relative paths or absolute URLs.

**Example:**
```properties
# Use relative links (recommended for most deployments)
openbanking.links.format=RELATIVE

# Or use absolute links
openbanking.links.format=ABSOLUTE
```

#### openbanking.links.base-url

**Property**: `openbanking.links.base-url`  
**Type**: String (URL)  
**Valid Values**: Any valid URL (must start with http:// or https://)  
**Default**: None  
**Required**: Yes (when `openbanking.links.format=ABSOLUTE`)

Specifies the base URL to be used when generating absolute links. This property is mandatory when using absolute link format.

**Example:**
```properties
openbanking.links.base-url=https://api.example.com
```

## Configuration Examples

### Example 1: Development Environment with Relative Links

For development environments, relative links are often preferred as they work across different host configurations.

```properties
# application.properties (Development)
server.port=8080
openbanking.links.format=RELATIVE
```

**Generated Links:**
```json
{
  "_links": {
    "self": {
      "href": "/v1/accounts/12345"
    }
  }
}
```

### Example 2: Production Environment with Absolute Links

For production environments, especially when dealing with multiple domains or strict API contracts, absolute links may be preferred.

```properties
# application.properties (Production)
server.port=8443
openbanking.links.format=ABSOLUTE
openbanking.links.base-url=https://openbanking.example.com
```

**Generated Links:**
```json
{
  "_links": {
    "self": {
      "href": "https://openbanking.example.com/v1/accounts/12345"
    }
  }
}
```

### Example 3: Behind Load Balancer/Reverse Proxy

When your application is behind a load balancer or reverse proxy:

```properties
# application.properties (Behind Proxy)
server.port=8080
openbanking.links.format=ABSOLUTE
openbanking.links.base-url=https://api-gateway.example.com
```

This ensures that clients receive the public-facing URL, not the internal service URL.

## Environment-Specific Configuration

### Using Spring Profiles

You can use Spring profiles to maintain different configurations for different environments:

#### application-dev.properties
```properties
openbanking.links.format=RELATIVE
```

#### application-staging.properties
```properties
openbanking.links.format=ABSOLUTE
openbanking.links.base-url=https://staging-api.example.com
```

#### application-prod.properties
```properties
openbanking.links.format=ABSOLUTE
openbanking.links.base-url=https://api.example.com
```

Activate a profile using:
```bash
java -jar application.jar --spring.profiles.active=prod
```

### Environment Variables

Configuration can also be provided through environment variables:

```bash
export OPENBANKING_LINKS_FORMAT=ABSOLUTE
export OPENBANKING_LINKS_BASE_URL=https://api.example.com
```

Spring Boot automatically maps environment variables using the naming convention:
- `openbanking.links.format` → `OPENBANKING_LINKS_FORMAT`
- `openbanking.links.base-url` → `OPENBANKING_LINKS_BASE_URL`

## Configuration Validation

### Startup Validation

The application validates configuration at startup to ensure:

1. If `openbanking.links.format=ABSOLUTE`, then `openbanking.links.base-url` must be provided
2. The base URL (if provided) must be a valid URL format
3. The base URL should use HTTPS in production environments (warning if HTTP is used)

### Configuration Errors

If configuration is invalid, the application will:
- Log a clear error message indicating the problem
- Provide guidance on how to fix the configuration
- Fail to start (fail-fast approach) to prevent misconfigured deployments

**Example Error:**
```
Error: openbanking.links.format is set to ABSOLUTE but openbanking.links.base-url is not configured.
Please add openbanking.links.base-url property with a valid URL.
```

## Migration Guide

### Changing from Relative to Absolute Links

If you need to change from relative to absolute links:

1. Add the `openbanking.links.base-url` property
2. Change `openbanking.links.format` to `ABSOLUTE`
3. Test all API responses to ensure links are generated correctly
4. Update any client documentation or SDKs if necessary

**Before:**
```properties
openbanking.links.format=RELATIVE
```

**After:**
```properties
openbanking.links.format=ABSOLUTE
openbanking.links.base-url=https://api.example.com
```

### Changing from Absolute to Relative Links

If you need to change from absolute to relative links:

1. Change `openbanking.links.format` to `RELATIVE`
2. Remove or comment out `openbanking.links.base-url` (no longer needed)
3. Test all API responses to ensure links work correctly
4. Update any client documentation or SDKs if necessary

## Best Practices

### 1. Use Relative Links for Flexibility

Relative links are recommended for most use cases as they:
- Work seamlessly across different environments
- Reduce response payload size
- Simplify proxy and load balancer configurations

### 2. Use Absolute Links for External APIs

Consider absolute links when:
- Providing a public API to external partners
- Working with strict API contracts that require full URLs
- Supporting clients that may not maintain base URL context

### 3. Document Your Choice

Clearly document in your API documentation which link format is used and why. This helps API consumers understand what to expect.

### 4. Keep Configuration Consistent

Avoid changing link format frequently as it may break client integrations. Choose one format and stick with it unless there's a compelling reason to change.

### 5. Use HTTPS in Production

Always use HTTPS for absolute URLs in production environments to ensure secure communication.

## Troubleshooting

### Links Not Generated Correctly

**Problem**: Links in `_links` field are not formatted as expected.

**Solution**: 
1. Verify the `openbanking.links.format` property is set correctly
2. Check application logs for configuration warnings or errors
3. If using absolute links, ensure `openbanking.links.base-url` is set

### Base URL Not Applied

**Problem**: Absolute links are not using the configured base URL.

**Solution**:
1. Verify `openbanking.links.format=ABSOLUTE`
2. Check that `openbanking.links.base-url` is configured
3. Restart the application to ensure configuration is loaded
4. Check for typos in property names

### Configuration Not Taking Effect

**Problem**: Changes to configuration are not reflected in the application.

**Solution**:
1. Ensure you're editing the correct `application.properties` file
2. Restart the application after making changes
3. Check if environment variables or Spring profiles are overriding your settings
4. Verify file permissions allow reading the properties file

## References

- [Spring Boot Configuration Properties](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html)
- [Spring Boot Externalized Configuration](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config)
- [_links Field Implementation Guide](./LINKS_FIELD_IMPLEMENTATION.md)

## Support

For configuration issues or questions:
1. Check the application logs for error messages
2. Review the [_links Field Implementation Guide](./LINKS_FIELD_IMPLEMENTATION.md)
3. Contact the development team for assistance
