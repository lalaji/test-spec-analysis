package org.openapitools.service;

import org.openapitools.model.SpecificationChange;
import org.openapitools.model.SpecificationMetadata;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Service for managing specification metadata including licensing and attribution information
 * Implements Berlin Group REQ_0014 compliance for specification redistribution
 */
@Service
public class SpecificationLicenseService {

    private SpecificationMetadata metadata;

    public SpecificationLicenseService() {
        initializeDefaultMetadata();
    }

    /**
     * Initialize default metadata for Berlin Group specification
     */
    private void initializeDefaultMetadata() {
        metadata = new SpecificationMetadata()
                .specificationName("Berlin Group Open Banking API Specification")
                .version("v1.0.3")
                .licenseName("Creative Commons Attribution 4.0 International (CC BY 4.0)")
                .licenseUrl("https://creativecommons.org/licenses/by/4.0/")
                .attributionText("Berlin Group - Open Banking API Specification. " +
                        "Original source: Berlin Group. " +
                        "This specification can be copied and redistributed in any medium or format " +
                        "for any purpose, even commercially. When shared, appropriate credit must be given, " +
                        "a link to the license must be provided, and changes must be indicated.")
                .originalSource("Berlin Group")
                .redistributionAllowed(true)
                .commercialUseAllowed(true)
                .changes(new ArrayList<>());
    }

    /**
     * Get the current specification metadata
     * 
     * @return SpecificationMetadata containing license and attribution information
     */
    public SpecificationMetadata getMetadata() {
        return metadata;
    }

    /**
     * Add a change record to track modifications to the specification
     * Required for REQ_0014 compliance to indicate changes made
     * 
     * @param description Description of the change
     * @param changedBy Who made the change
     * @param changeType Type of change (e.g., "addition", "modification", "deletion")
     * @param affectedSection Section of specification affected
     * @return The created SpecificationChange
     */
    public SpecificationChange addChange(String description, String changedBy, 
                                        String changeType, String affectedSection) {
        SpecificationChange change = new SpecificationChange()
                .changeId(UUID.randomUUID().toString())
                .description(description)
                .changedBy(changedBy)
                .changeDate(OffsetDateTime.now())
                .changeType(changeType)
                .affectedSection(affectedSection);
        
        metadata.addChangesItem(change);
        return change;
    }

    /**
     * Get all changes made to the specification
     * 
     * @return List of all specification changes
     */
    public List<SpecificationChange> getChanges() {
        return metadata.getChanges();
    }

    /**
     * Verify compliance with REQ_0014 requirements
     * Checks that all required attribution and license information is present
     * 
     * @return true if compliant, false otherwise
     */
    public boolean verifyCompliance() {
        return metadata.getLicenseName() != null && !metadata.getLicenseName().isEmpty() &&
               metadata.getLicenseUrl() != null && !metadata.getLicenseUrl().isEmpty() &&
               metadata.getAttributionText() != null && !metadata.getAttributionText().isEmpty() &&
               metadata.getRedistributionAllowed() != null &&
               metadata.getCommercialUseAllowed() != null;
    }

    /**
     * Get compliance status message
     * 
     * @return Compliance status message
     */
    public String getComplianceStatus() {
        if (verifyCompliance()) {
            return "COMPLIANT: All REQ_0014 requirements are met. " +
                   "Specification includes proper license information, attribution, " +
                   "and change tracking capabilities.";
        } else {
            return "NON_COMPLIANT: Missing required REQ_0014 information. " +
                   "Please ensure license name, license URL, and attribution text are provided.";
        }
    }

    /**
     * Update metadata with custom values
     * Note: This will preserve existing changes. If you want to replace all data including changes,
     * set the changes list on the newMetadata before calling this method.
     * 
     * @param newMetadata The new metadata to set
     */
    public void updateMetadata(SpecificationMetadata newMetadata) {
        // Preserve existing changes if the new metadata doesn't have any
        if (newMetadata.getChanges() == null || newMetadata.getChanges().isEmpty()) {
            List<SpecificationChange> existingChanges = this.metadata.getChanges();
            this.metadata = newMetadata;
            this.metadata.setChanges(existingChanges);
        } else {
            this.metadata = newMetadata;
        }
    }
}
