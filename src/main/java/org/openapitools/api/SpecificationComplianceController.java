package org.openapitools.api;

import org.openapitools.model.SpecificationChange;
import org.openapitools.model.SpecificationMetadata;
import org.openapitools.service.SpecificationLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * REST API Controller for specification license and compliance management
 * Implements Berlin Group REQ_0014 compliance endpoints
 */
@RestController
@RequestMapping("/api/specification")
public class SpecificationComplianceController {

    @Autowired
    private SpecificationLicenseService licenseService;

    /**
     * Get specification metadata including license and attribution information
     * 
     * @return Specification metadata
     */
    @GetMapping("/metadata")
    public ResponseEntity<SpecificationMetadata> getMetadata() {
        return ResponseEntity.ok(licenseService.getMetadata());
    }

    /**
     * Get license information for the specification
     * 
     * @return License information
     */
    @GetMapping("/license")
    public ResponseEntity<Map<String, String>> getLicenseInfo() {
        SpecificationMetadata metadata = licenseService.getMetadata();
        Map<String, String> license = new HashMap<>();
        license.put("licenseName", metadata.getLicenseName());
        license.put("licenseUrl", metadata.getLicenseUrl());
        license.put("attributionText", metadata.getAttributionText());
        return ResponseEntity.ok(license);
    }

    /**
     * Get all changes made to the specification
     * 
     * @return List of specification changes
     */
    @GetMapping("/changes")
    public ResponseEntity<List<SpecificationChange>> getChanges() {
        return ResponseEntity.ok(licenseService.getChanges());
    }

    /**
     * Add a new change record to the specification
     * 
     * @param changeRequest Change request details
     * @return The created change record
     */
    @PostMapping("/changes")
    public ResponseEntity<SpecificationChange> addChange(@RequestBody Map<String, String> changeRequest) {
        String description = changeRequest.get("description");
        String changedBy = changeRequest.get("changedBy");
        String changeType = changeRequest.get("changeType");
        String affectedSection = changeRequest.get("affectedSection");

        if (description == null || changedBy == null) {
            return ResponseEntity.badRequest().build();
        }

        SpecificationChange change = licenseService.addChange(
            description, 
            changedBy, 
            changeType, 
            affectedSection
        );
        
        return ResponseEntity.status(HttpStatus.CREATED).body(change);
    }

    /**
     * Verify REQ_0014 compliance
     * 
     * @return Compliance verification result
     */
    @GetMapping("/compliance/verify")
    public ResponseEntity<Map<String, Object>> verifyCompliance() {
        Map<String, Object> result = new HashMap<>();
        result.put("compliant", licenseService.verifyCompliance());
        result.put("status", licenseService.getComplianceStatus());
        result.put("requirementId", "REQ_0014");
        result.put("specification", "Berlin Group");
        return ResponseEntity.ok(result);
    }

    /**
     * Get attribution text for proper crediting
     * 
     * @return Attribution text
     */
    @GetMapping("/attribution")
    public ResponseEntity<Map<String, String>> getAttribution() {
        SpecificationMetadata metadata = licenseService.getMetadata();
        Map<String, String> attribution = new HashMap<>();
        attribution.put("attributionText", metadata.getAttributionText());
        attribution.put("originalSource", metadata.getOriginalSource());
        attribution.put("specificationName", metadata.getSpecificationName());
        attribution.put("version", metadata.getVersion());
        return ResponseEntity.ok(attribution);
    }
}
