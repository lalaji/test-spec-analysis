package org.openapitools.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for GeoLocationValidator
 */
class GeoLocationValidatorTest {
    
    @Test
    void testValidGeoLocation() {
        // Valid geographical coordinates
        assertTrue(GeoLocationValidator.isValid("GEO:52.506931;13.144558"));
        assertTrue(GeoLocationValidator.isValid("geo:52.506931;13.144558")); // Case insensitive
        assertTrue(GeoLocationValidator.isValid("GEO:0;0")); // Equator and Prime Meridian
        assertTrue(GeoLocationValidator.isValid("GEO:90;180")); // North Pole, Date Line
        assertTrue(GeoLocationValidator.isValid("GEO:-90;-180")); // South Pole
        assertTrue(GeoLocationValidator.isValid("GEO:52.5;13.4")); // One decimal place
        assertTrue(GeoLocationValidator.isValid("GEO:-34.603722;-58.381592")); // Buenos Aires
    }
    
    @Test
    void testInvalidGeoLocationFormat() {
        // Missing GEO prefix
        assertFalse(GeoLocationValidator.isValid("52.506931;13.144558"));
        
        // Wrong separator
        assertFalse(GeoLocationValidator.isValid("GEO:52.506931,13.144558"));
        
        // Missing longitude
        assertFalse(GeoLocationValidator.isValid("GEO:52.506931"));
        
        // Missing latitude
        assertFalse(GeoLocationValidator.isValid("GEO:;13.144558"));
        
        // Empty string
        assertFalse(GeoLocationValidator.isValid(""));
        
        // Null value
        assertFalse(GeoLocationValidator.isValid(null));
        
        // Only whitespace
        assertFalse(GeoLocationValidator.isValid("   "));
        
        // Invalid characters
        assertFalse(GeoLocationValidator.isValid("GEO:abc;def"));
    }
    
    @Test
    void testInvalidLatitude() {
        // Latitude > 90
        assertFalse(GeoLocationValidator.isValid("GEO:91;13.144558"));
        assertFalse(GeoLocationValidator.isValid("GEO:100;0"));
        
        // Latitude < -90
        assertFalse(GeoLocationValidator.isValid("GEO:-91;13.144558"));
        assertFalse(GeoLocationValidator.isValid("GEO:-100;0"));
    }
    
    @Test
    void testInvalidLongitude() {
        // Longitude > 180
        assertFalse(GeoLocationValidator.isValid("GEO:52.506931;181"));
        assertFalse(GeoLocationValidator.isValid("GEO:0;200"));
        
        // Longitude < -180
        assertFalse(GeoLocationValidator.isValid("GEO:52.506931;-181"));
        assertFalse(GeoLocationValidator.isValid("GEO:0;-200"));
    }
    
    @Test
    void testBoundaryValues() {
        // Valid boundary values
        assertTrue(GeoLocationValidator.isValid("GEO:90;180"));
        assertTrue(GeoLocationValidator.isValid("GEO:-90;-180"));
        assertTrue(GeoLocationValidator.isValid("GEO:90;-180"));
        assertTrue(GeoLocationValidator.isValid("GEO:-90;180"));
        
        // Just beyond boundary
        assertFalse(GeoLocationValidator.isValid("GEO:90.1;180"));
        assertFalse(GeoLocationValidator.isValid("GEO:90;180.1"));
        assertFalse(GeoLocationValidator.isValid("GEO:-90.1;-180"));
        assertFalse(GeoLocationValidator.isValid("GEO:-90;-180.1"));
    }
    
    @Test
    void testGetValidationErrorForNull() {
        String error = GeoLocationValidator.getValidationError(null);
        assertNotNull(error);
        assertTrue(error.contains("required"));
    }
    
    @Test
    void testGetValidationErrorForEmpty() {
        String error = GeoLocationValidator.getValidationError("");
        assertNotNull(error);
        assertTrue(error.contains("required"));
    }
    
    @Test
    void testGetValidationErrorForMissingPrefix() {
        String error = GeoLocationValidator.getValidationError("52.506931;13.144558");
        assertNotNull(error);
        assertTrue(error.toLowerCase().contains("geo:"));
    }
    
    @Test
    void testGetValidationErrorForInvalidFormat() {
        String error = GeoLocationValidator.getValidationError("GEO:invalid");
        assertNotNull(error);
        assertTrue(error.toLowerCase().contains("format"));
    }
    
    @Test
    void testGetValidationErrorForInvalidLatitude() {
        String error = GeoLocationValidator.getValidationError("GEO:100;0");
        assertNotNull(error);
        assertTrue(error.toLowerCase().contains("latitude"));
    }
    
    @Test
    void testGetValidationErrorForInvalidLongitude() {
        String error = GeoLocationValidator.getValidationError("GEO:0;200");
        assertNotNull(error);
        assertTrue(error.toLowerCase().contains("longitude"));
    }
    
    @Test
    void testGetValidationErrorForValidInput() {
        String error = GeoLocationValidator.getValidationError("GEO:52.506931;13.144558");
        assertNull(error);
    }
    
    @Test
    void testRealWorldCoordinates() {
        // Berlin, Germany
        assertTrue(GeoLocationValidator.isValid("GEO:52.520008;13.404954"));
        
        // London, UK
        assertTrue(GeoLocationValidator.isValid("GEO:51.507351;-0.127758"));
        
        // New York, USA
        assertTrue(GeoLocationValidator.isValid("GEO:40.712776;-74.005974"));
        
        // Tokyo, Japan
        assertTrue(GeoLocationValidator.isValid("GEO:35.689487;139.691711"));
        
        // Sydney, Australia
        assertTrue(GeoLocationValidator.isValid("GEO:-33.868820;151.209290"));
    }
}
