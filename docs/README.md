# Documentation Index

Welcome to the WSO2 Open Banking API documentation. This documentation provides comprehensive guidance on implementing Berlin Group compliant APIs with proper `_links` field support.

## Berlin Group Compliance

### REQ_1108 - _links Field Implementation

**Requirement**: All links in `_links` field can be relative or full links, to be decided by the ASPSP.

This implementation provides full compliance with this requirement through configurable link formatting options.

## Documentation Structure

### 1. [_links Field Implementation Guide](LINKS_FIELD_IMPLEMENTATION.md)

The primary guide for understanding and implementing the `_links` field in API responses.

**Topics Covered:**
- Overview of the `_links` field and HATEOAS
- Link format options (relative vs absolute)
- API response structure guidelines
- Implementation best practices
- Security considerations
- Testing guidelines
- Compliance verification

**Audience**: Developers, API Designers, Technical Architects

### 2. [Configuration Guide](CONFIGURATION_GUIDE.md)

Detailed instructions on configuring the `_links` field behavior.

**Topics Covered:**
- Configuration properties explained
- Configuration examples for different environments
- Environment-specific configuration using Spring profiles
- Configuration validation
- Migration guide for changing link formats
- Troubleshooting common configuration issues

**Audience**: DevOps Engineers, System Administrators, Developers

### 3. [API Response Examples](API_RESPONSE_EXAMPLES.md)

Comprehensive collection of example API responses demonstrating `_links` field usage.

**Topics Covered:**
- Basic response examples
- Paginated responses
- Nested resources
- Error responses
- Consent responses
- Payment responses
- Common patterns and best practices

**Audience**: API Consumers, Frontend Developers, API Designers

## Quick Start

### For Developers

1. Start with the [_links Field Implementation Guide](LINKS_FIELD_IMPLEMENTATION.md) to understand the concepts
2. Review [API Response Examples](API_RESPONSE_EXAMPLES.md) to see practical implementations
3. Follow the [Configuration Guide](CONFIGURATION_GUIDE.md) to set up your environment

### For API Consumers

1. Review [API Response Examples](API_RESPONSE_EXAMPLES.md) to understand response structure
2. Check the configuration being used (relative vs absolute links) with your ASPSP

### For DevOps/Administrators

1. Start with the [Configuration Guide](CONFIGURATION_GUIDE.md)
2. Review environment-specific configuration examples
3. Set up appropriate configuration for your deployment environment

## Key Concepts

### HATEOAS (Hypermedia as the Engine of Application State)

The `_links` field implements HATEOAS principles, allowing API clients to discover and navigate resources dynamically without hardcoding URLs.

### Link Format Options

- **Relative Links**: Path-only URLs (e.g., `/v1/accounts/123`)
  - Recommended for most use cases
  - Environment-agnostic
  - Smaller response payloads

- **Absolute Links**: Full URLs (e.g., `https://api.example.com/v1/accounts/123`)
  - Required for some external API contracts
  - Self-contained URLs
  - Easier for clients without base URL context

## Compliance Checklist

Use this checklist to verify your implementation is compliant with REQ_1108:

- [ ] API responses include `_links` field where appropriate
- [ ] Links can be configured as relative or absolute
- [ ] Configuration property `openbanking.links.format` is available
- [ ] Configuration property `openbanking.links.base-url` is available for absolute links
- [ ] Link format is consistent across all endpoints
- [ ] Documentation clearly describes the link format implementation
- [ ] API consumers are informed of the link format being used

## Common Use Cases

### Use Case 1: Development Environment

**Scenario**: Local development with frequently changing ports and hosts

**Recommendation**: Use relative links
```properties
openbanking.links.format=RELATIVE
```

### Use Case 2: Production API

**Scenario**: Public-facing API with fixed domain

**Recommendation**: Either format works, but absolute links may be preferred for external partners
```properties
openbanking.links.format=ABSOLUTE
openbanking.links.base-url=https://api.production.com
```

### Use Case 3: Behind Load Balancer

**Scenario**: Application behind reverse proxy or load balancer

**Recommendation**: Use absolute links with the public-facing URL
```properties
openbanking.links.format=ABSOLUTE
openbanking.links.base-url=https://api-gateway.example.com
```

## Berlin Group Framework References

This implementation follows the Berlin Group NextGenPSD2 Framework specifications:

- **Framework Version**: Latest (compatible with multiple versions)
- **Requirement ID**: REQ_1108
- **Capability**: Functional Resources (The "Products")
- **Strength**: MUST
- **Compliance Status**: ✅ Fully Compliant

## Additional Resources

### External References

- [Berlin Group NextGenPSD2 Framework](https://www.berlin-group.org/)
- [IANA Link Relations](https://www.iana.org/assignments/link-relations/link-relations.xhtml)
- [RFC 3986 - URI Generic Syntax](https://tools.ietf.org/html/rfc3986)
- [HATEOAS Principles](https://restfulapi.net/hateoas/)

### Spring Boot Resources

- [Spring Boot Configuration](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html)
- [Spring HATEOAS](https://spring.io/projects/spring-hateoas)

## Support and Feedback

For questions, issues, or feedback regarding this documentation or the `_links` field implementation:

1. Review the relevant documentation sections
2. Check the troubleshooting sections in the [Configuration Guide](CONFIGURATION_GUIDE.md)
3. Contact the development team

## Version History

### Version 1.0.0 (Initial Release)

- Complete implementation of REQ_1108 compliance
- Documentation for _links field implementation
- Configuration guide for link formatting
- Comprehensive API response examples
- Support for both relative and absolute link formats

---

**Last Updated**: 2024-02-13  
**Documentation Version**: 1.0.0  
**Implementation Version**: v1.0.3
