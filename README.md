# test-spec-analysis

## Open Banking Specification Compliance Implementation

This project implements WSO2 Open Banking toolkit extensions with full compliance for Berlin Group NextGenPSD2 specification requirements, including REQ_0014 (specification redistribution and attribution).

## Compliance Features

- **Specification Metadata Management**: Track and manage specification licenses and attributions
- **Attribution Tracking**: Automated attribution information through REST APIs
- **License Management**: Programmatic access to license terms
- **Change Tracking**: Comprehensive logging of specification modifications

## API Endpoints

### Compliance APIs

Access specification metadata and compliance information:

- `GET /api/compliance/specifications` - List all specifications
- `GET /api/compliance/specifications/{id}` - Get specification metadata
- `GET /api/compliance/specifications/{id}/license` - Get license information
- `GET /api/compliance/specifications/{id}/attribution` - Get attribution details
- `GET /api/compliance/specifications/{id}/changes` - Get change log

### Example Usage

```bash
# Get Berlin Group specification metadata
curl http://localhost:8080/api/compliance/specifications/berlin-group

# Get license information
curl http://localhost:8080/api/compliance/specifications/berlin-group/license

# Get attribution requirements
curl http://localhost:8080/api/compliance/specifications/berlin-group/attribution
```

## Documentation

- [COMPLIANCE.md](COMPLIANCE.md) - Full compliance and attribution documentation
- [LICENSE](LICENSE) - Apache 2.0 License

## Building and Running

```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The application will start on port 8080 by default.

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

## Attribution

This implementation is based on the Berlin Group NextGenPSD2 Framework. Original specification © Berlin Group. Used under Creative Commons Attribution 4.0 International License.