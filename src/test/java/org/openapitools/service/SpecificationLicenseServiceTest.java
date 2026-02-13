package org.openapitools.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapitools.model.SpecificationChange;
import org.openapitools.model.SpecificationMetadata;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for SpecificationLicenseService
 * Tests REQ_0014 compliance features
 */
public class SpecificationLicenseServiceTest {

    private SpecificationLicenseService service;

    @BeforeEach
    public void setUp() {
        service = new SpecificationLicenseService();
    }

    @Test
    public void testGetMetadata() {
        SpecificationMetadata metadata = service.getMetadata();
        
        assertNotNull(metadata);
        assertNotNull(metadata.getSpecificationName());
        assertNotNull(metadata.getVersion());
        assertNotNull(metadata.getLicenseName());
        assertNotNull(metadata.getLicenseUrl());
        assertNotNull(metadata.getAttributionText());
    }

    @Test
    public void testLicenseInformationIsPresent() {
        SpecificationMetadata metadata = service.getMetadata();
        
        assertEquals("Berlin Group Open Banking API Specification", metadata.getSpecificationName());
        assertEquals("v1.0.3", metadata.getVersion());
        assertEquals("Creative Commons Attribution 4.0 International (CC BY 4.0)", metadata.getLicenseName());
        assertEquals("https://creativecommons.org/licenses/by/4.0/", metadata.getLicenseUrl());
        assertTrue(metadata.getAttributionText().contains("Berlin Group"));
    }

    @Test
    public void testRedistributionPermissions() {
        SpecificationMetadata metadata = service.getMetadata();
        
        assertTrue(metadata.getRedistributionAllowed());
        assertTrue(metadata.getCommercialUseAllowed());
    }

    @Test
    public void testAddChange() {
        SpecificationChange change = service.addChange(
            "Updated API endpoint", 
            "Test User", 
            "modification", 
            "Section 3.2"
        );
        
        assertNotNull(change);
        assertNotNull(change.getChangeId());
        assertEquals("Updated API endpoint", change.getDescription());
        assertEquals("Test User", change.getChangedBy());
        assertEquals("modification", change.getChangeType());
        assertEquals("Section 3.2", change.getAffectedSection());
        assertNotNull(change.getChangeDate());
    }

    @Test
    public void testGetChanges() {
        service.addChange("Change 1", "User 1", "addition", "Section 1");
        service.addChange("Change 2", "User 2", "deletion", "Section 2");
        
        assertEquals(2, service.getChanges().size());
    }

    @Test
    public void testVerifyCompliance() {
        assertTrue(service.verifyCompliance());
    }

    @Test
    public void testGetComplianceStatus() {
        String status = service.getComplianceStatus();
        
        assertNotNull(status);
        assertTrue(status.contains("COMPLIANT"));
        assertTrue(status.contains("REQ_0014"));
    }

    @Test
    public void testUpdateMetadata() {
        SpecificationMetadata newMetadata = new SpecificationMetadata()
            .specificationName("Test Spec")
            .version("v2.0")
            .licenseName("Apache 2.0")
            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
            .attributionText("Test attribution")
            .redistributionAllowed(true)
            .commercialUseAllowed(true);
        
        service.updateMetadata(newMetadata);
        
        assertEquals("Test Spec", service.getMetadata().getSpecificationName());
        assertEquals("v2.0", service.getMetadata().getVersion());
    }

    @Test
    public void testNonCompliantMetadata() {
        SpecificationMetadata incompleteMetadata = new SpecificationMetadata()
            .specificationName("Test")
            .version("1.0");
        
        service.updateMetadata(incompleteMetadata);
        
        assertFalse(service.verifyCompliance());
        assertTrue(service.getComplianceStatus().contains("NON_COMPLIANT"));
    }
}
