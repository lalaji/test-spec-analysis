# _links Field Implementation Guide

## Overview

This document provides comprehensive guidelines for implementing the `_links` field in API responses according to the Berlin Group specification requirement REQ_1108.

## Requirement

**REQ_1108**: All links in `_links` field can be relative or full links, to be decided by the ASPSP (Account Servicing Payment Service Provider).

**Capability**: Functional Resources (The "Products")  
**Strength**: MUST  
**Compliance Level**: Berlin Group Specification

## Purpose

The `_links` field provides HATEOAS (Hypermedia as the Engine of Application State) support in API responses, enabling clients to discover and navigate related resources dynamically without hardcoding URLs.

## Link Format Options

The ASPSP has the flexibility to choose between two link format options:

### 1. Relative Links

Relative links provide only the path portion of the URL, relative to the API base URL.

**Advantages:**
- Smaller response payload size
- Environment-agnostic (works across different environments without changes)
- Easier to handle proxy and load balancer scenarios

**Example:**
```json
{
  "_links": {
    "self": {
      "href": "/v1/accounts/12345"
    },
    "transactions": {
      "href": "/v1/accounts/12345/transactions"
    }
  }
}
```

### 2. Absolute (Full) Links

Absolute links provide the complete URL including scheme, host, and path.

**Advantages:**
- Self-contained and directly usable
- No ambiguity about the target endpoint
- Easier for clients that don't maintain base URL context

**Example:**
```json
{
  "_links": {
    "self": {
      "href": "https://api.example.com/v1/accounts/12345"
    },
    "transactions": {
      "href": "https://api.example.com/v1/accounts/12345/transactions"
    }
  }
}
```

## Configuration

The link format is configurable through application properties. See the configuration guide below for details on how to set the preferred link format for your ASPSP implementation.

### Application Properties

Add the following configuration to `application.properties`:

```properties
# Link format configuration for _links field
# Options: RELATIVE, ABSOLUTE
openbanking.links.format=RELATIVE

# Base URL for absolute links (required when format is ABSOLUTE)
openbanking.links.base-url=https://api.example.com
```

## API Response Structure Guidelines

### Standard _links Structure

The `_links` field should be included in API responses that support HATEOAS. The structure follows these guidelines:

1. **Field Name**: Always use `_links` (with underscore prefix)
2. **Type**: Object containing named link relations
3. **Link Relations**: Each relation should have at least an `href` property
4. **Common Relations**: 
   - `self`: Link to the current resource
   - `first`, `prev`, `next`, `last`: Pagination links
   - Resource-specific relations (e.g., `transactions`, `balances`)

### Complete Response Example

```json
{
  "accounts": [
    {
      "accountId": "12345",
      "iban": "DE89370400440532013000",
      "currency": "EUR",
      "name": "Main Account",
      "_links": {
        "self": {
          "href": "/v1/accounts/12345"
        },
        "balances": {
          "href": "/v1/accounts/12345/balances"
        },
        "transactions": {
          "href": "/v1/accounts/12345/transactions"
        }
      }
    }
  ],
  "_links": {
    "self": {
      "href": "/v1/accounts?page=1"
    },
    "next": {
      "href": "/v1/accounts?page=2"
    },
    "last": {
      "href": "/v1/accounts?page=10"
    }
  }
}
```

## Implementation Best Practices

### 1. Consistency

- Maintain consistent link format across all API endpoints
- Use the same format (relative or absolute) throughout the entire API

### 2. Link Relations

- Use standard IANA link relations where applicable
- Document custom link relations specific to your API

### 3. Pagination

- Always include pagination links (`first`, `prev`, `next`, `last`) for paginated resources
- Omit `prev` on the first page and `next` on the last page

### 4. Conditional Links

- Only include links that are applicable in the current context
- Consider user permissions when generating links

### 5. URL Encoding

- Properly encode URL parameters in link hrefs
- Follow RFC 3986 for URL encoding

## Security Considerations

1. **HTTPS**: Always use HTTPS for absolute URLs in production
2. **Authorization**: Ensure clients have proper authorization before following links
3. **URL Validation**: Validate and sanitize all URL components
4. **No Sensitive Data**: Avoid including sensitive information in URLs

## Testing

When implementing `_links` field support, ensure you test:

1. **Format Consistency**: Verify all links use the configured format
2. **Valid URLs**: Ensure all generated URLs are valid and accessible
3. **Pagination**: Test pagination links work correctly
4. **Edge Cases**: Test with special characters, long URLs, etc.
5. **Configuration Changes**: Verify switching between relative and absolute works correctly

## Compliance Verification

To verify compliance with REQ_1108:

1. ✅ API responses include `_links` field where appropriate
2. ✅ Links can be configured as relative or absolute
3. ✅ Link format is consistent across all endpoints
4. ✅ Documentation clearly describes the link format implementation
5. ✅ Configuration options are available to ASPSPs

## References

- Berlin Group NextGenPSD2 Framework
- [IANA Link Relations](https://www.iana.org/assignments/link-relations/link-relations.xhtml)
- [RFC 3986 - URI Generic Syntax](https://tools.ietf.org/html/rfc3986)
- [HATEOAS Principles](https://restfulapi.net/hateoas/)

## Support

For questions or issues related to `_links` field implementation, please refer to:
- API Documentation
- Configuration Guide
- Development Team Contact
