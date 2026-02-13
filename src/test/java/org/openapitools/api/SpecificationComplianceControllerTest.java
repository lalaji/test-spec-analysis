package org.openapitools.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openapitools.model.SpecificationChange;
import org.openapitools.model.SpecificationMetadata;
import org.openapitools.service.SpecificationLicenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for SpecificationComplianceController
 * Tests REQ_0014 compliance API endpoints
 */
public class SpecificationComplianceControllerTest {

    @Mock
    private SpecificationLicenseService licenseService;

    @InjectMocks
    private SpecificationComplianceController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetMetadata() {
        SpecificationMetadata metadata = new SpecificationMetadata()
            .specificationName("Berlin Group")
            .version("v1.0.3")
            .licenseName("CC BY 4.0")
            .licenseUrl("https://creativecommons.org/licenses/by/4.0/");
        
        when(licenseService.getMetadata()).thenReturn(metadata);
        
        ResponseEntity<SpecificationMetadata> response = controller.getMetadata();
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Berlin Group", response.getBody().getSpecificationName());
    }

    @Test
    public void testGetLicenseInfo() {
        SpecificationMetadata metadata = new SpecificationMetadata()
            .licenseName("CC BY 4.0")
            .licenseUrl("https://creativecommons.org/licenses/by/4.0/")
            .attributionText("Berlin Group");
        
        when(licenseService.getMetadata()).thenReturn(metadata);
        
        ResponseEntity<Map<String, String>> response = controller.getLicenseInfo();
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("CC BY 4.0", response.getBody().get("licenseName"));
        assertEquals("https://creativecommons.org/licenses/by/4.0/", response.getBody().get("licenseUrl"));
    }

    @Test
    public void testGetChanges() {
        List<SpecificationChange> changes = new ArrayList<>();
        changes.add(new SpecificationChange()
            .changeId("1")
            .description("Test change")
            .changedBy("User")
            .changeDate(OffsetDateTime.now()));
        
        when(licenseService.getChanges()).thenReturn(changes);
        
        ResponseEntity<List<SpecificationChange>> response = controller.getChanges();
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    public void testAddChange() {
        Map<String, String> changeRequest = new HashMap<>();
        changeRequest.put("description", "New change");
        changeRequest.put("changedBy", "Test User");
        changeRequest.put("changeType", "addition");
        changeRequest.put("affectedSection", "Section 1");
        
        SpecificationChange change = new SpecificationChange()
            .changeId("123")
            .description("New change")
            .changedBy("Test User");
        
        when(licenseService.addChange(anyString(), anyString(), anyString(), anyString()))
            .thenReturn(change);
        
        ResponseEntity<SpecificationChange> response = controller.addChange(changeRequest);
        
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("New change", response.getBody().getDescription());
    }

    @Test
    public void testAddChangeWithMissingFields() {
        Map<String, String> changeRequest = new HashMap<>();
        changeRequest.put("description", "New change");
        // Missing changedBy
        
        ResponseEntity<SpecificationChange> response = controller.addChange(changeRequest);
        
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testVerifyCompliance() {
        when(licenseService.verifyCompliance()).thenReturn(true);
        when(licenseService.getComplianceStatus()).thenReturn("COMPLIANT");
        
        ResponseEntity<Map<String, Object>> response = controller.verifyCompliance();
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue((Boolean) response.getBody().get("compliant"));
        assertEquals("REQ_0014", response.getBody().get("requirementId"));
        assertEquals("Berlin Group", response.getBody().get("specification"));
    }

    @Test
    public void testGetAttribution() {
        SpecificationMetadata metadata = new SpecificationMetadata()
            .specificationName("Berlin Group")
            .version("v1.0.3")
            .attributionText("Berlin Group Attribution")
            .originalSource("Berlin Group");
        
        when(licenseService.getMetadata()).thenReturn(metadata);
        
        ResponseEntity<Map<String, String>> response = controller.getAttribution();
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Berlin Group Attribution", response.getBody().get("attributionText"));
        assertEquals("Berlin Group", response.getBody().get("originalSource"));
    }
}
