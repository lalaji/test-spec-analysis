# test-spec-analysis

WSO2 Open Banking API Implementation with Berlin Group Compliance

## Overview

This is a Spring Boot application that implements the WSO2 Open Banking accelerator extension points, compliant with Berlin Group specifications.

## Berlin Group Compliance

### _links Field Implementation (REQ_1108)

This implementation supports the Berlin Group requirement REQ_1108, which mandates that all links in the `_links` field can be either relative or full links, as decided by the ASPSP (Account Servicing Payment Service Provider).

**Key Features:**
- Configurable link format (relative or absolute)
- Full HATEOAS support for API discoverability
- Compliant with Berlin Group NextGenPSD2 Framework

**Documentation:**
- [_links Field Implementation Guide](docs/LINKS_FIELD_IMPLEMENTATION.md) - Comprehensive guide on implementing _links field
- [Configuration Guide](docs/CONFIGURATION_GUIDE.md) - Detailed configuration instructions
- [API Response Examples](docs/API_RESPONSE_EXAMPLES.md) - Complete examples of API responses with _links

## Configuration

### _links Field Configuration

Configure the link format in `src/main/resources/application.properties`:

```properties
# Link format: RELATIVE or ABSOLUTE
openbanking.links.format=RELATIVE

# Base URL for absolute links (required when format is ABSOLUTE)
#openbanking.links.base-url=https://api.example.com
```

See the [Configuration Guide](docs/CONFIGURATION_GUIDE.md) for detailed configuration options.

## Getting Started

### Prerequisites
- Java 8 or higher
- Maven 3.6 or higher

### Running the Application

```bash
mvn spring-boot:run
```

The application will start on port 8080 by default.

### Building the Application

```bash
mvn clean package
```

## API Documentation

Once the application is running, you can access:
- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI Specification: http://localhost:8080/v3/api-docs

## Documentation

- [_links Field Implementation](docs/LINKS_FIELD_IMPLEMENTATION.md)
- [Configuration Guide](docs/CONFIGURATION_GUIDE.md)
- [API Response Examples](docs/API_RESPONSE_EXAMPLES.md)

## License

Apache 2.0