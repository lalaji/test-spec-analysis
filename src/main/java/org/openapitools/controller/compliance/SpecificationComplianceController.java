package org.openapitools.controller.compliance;

import org.openapitools.model.compliance.SpecificationMetadata;
import org.openapitools.service.compliance.SpecificationComplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * REST Controller for specification compliance endpoints.
 * Provides access to specification metadata, licenses, and attribution information.
 * Implements REQ_0014 compliance requirements.
 */
@RestController
@RequestMapping("/api/compliance")
public class SpecificationComplianceController {

    private final SpecificationComplianceService complianceService;

    @Autowired
    public SpecificationComplianceController(SpecificationComplianceService complianceService) {
        this.complianceService = complianceService;
    }

    /**
     * Get metadata for a specific specification
     * GET /api/compliance/specifications/{specificationId}
     */
    @GetMapping("/specifications/{specificationId}")
    public ResponseEntity<SpecificationMetadata> getSpecificationMetadata(
            @PathVariable String specificationId) {
        SpecificationMetadata metadata = complianceService.getSpecificationMetadata(specificationId);
        if (metadata == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(metadata);
    }

    /**
     * Get all registered specifications
     * GET /api/compliance/specifications
     */
    @GetMapping("/specifications")
    public ResponseEntity<Map<String, SpecificationMetadata>> getAllSpecifications() {
        Map<String, SpecificationMetadata> specifications = complianceService.getAllSpecifications();
        return ResponseEntity.ok(specifications);
    }

    /**
     * Get license information for a specification
     * GET /api/compliance/specifications/{specificationId}/license
     */
    @GetMapping("/specifications/{specificationId}/license")
    public ResponseEntity<?> getLicenseInfo(@PathVariable String specificationId) {
        SpecificationMetadata metadata = complianceService.getSpecificationMetadata(specificationId);
        if (metadata == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Specification not found: " + specificationId);
        }
        if (metadata.getLicense() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("License information not available for: " + specificationId);
        }
        return ResponseEntity.ok(metadata.getLicense());
    }

    /**
     * Get attribution information for a specification
     * GET /api/compliance/specifications/{specificationId}/attribution
     */
    @GetMapping("/specifications/{specificationId}/attribution")
    public ResponseEntity<?> getAttributionInfo(@PathVariable String specificationId) {
        SpecificationMetadata metadata = complianceService.getSpecificationMetadata(specificationId);
        if (metadata == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Specification not found: " + specificationId);
        }
        if (metadata.getAttribution() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Attribution information not available for: " + specificationId);
        }
        return ResponseEntity.ok(metadata.getAttribution());
    }

    /**
     * Get change log for a specification
     * GET /api/compliance/specifications/{specificationId}/changes
     */
    @GetMapping("/specifications/{specificationId}/changes")
    public ResponseEntity<?> getChanges(@PathVariable String specificationId) {
        SpecificationMetadata metadata = complianceService.getSpecificationMetadata(specificationId);
        if (metadata == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Specification not found: " + specificationId);
        }
        return ResponseEntity.ok(metadata.getChanges());
    }
}
