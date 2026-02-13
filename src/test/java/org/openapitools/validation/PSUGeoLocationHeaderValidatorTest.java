package org.openapitools.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for PSUGeoLocationHeaderValidator
 */
class PSUGeoLocationHeaderValidatorTest {
    
    private PSUGeoLocationHeaderValidator validator;
    
    @BeforeEach
    void setUp() {
        validator = new PSUGeoLocationHeaderValidator();
    }
    
    @Test
    void testValidateHeaderSuccess() {
        // Should not throw exception for valid header
        assertDoesNotThrow(() -> validator.validateHeader("GEO:52.506931;13.144558"));
        assertDoesNotThrow(() -> validator.validateHeader("GEO:0;0"));
    }
    
    @Test
    void testValidateHeaderNullThrowsException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> validator.validateHeader(null)
        );
        assertTrue(exception.getMessage().contains("required"));
    }
    
    @Test
    void testValidateHeaderEmptyThrowsException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> validator.validateHeader("")
        );
        assertTrue(exception.getMessage().contains("required"));
    }
    
    @Test
    void testValidateHeaderInvalidFormatThrowsException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> validator.validateHeader("52.506931;13.144558")
        );
        assertNotNull(exception.getMessage());
    }
    
    @Test
    void testValidateHeaderInvalidLatitudeThrowsException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> validator.validateHeader("GEO:100;0")
        );
        assertTrue(exception.getMessage().toLowerCase().contains("latitude"));
    }
    
    @Test
    void testValidateHeaderInvalidLongitudeThrowsException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> validator.validateHeader("GEO:0;200")
        );
        assertTrue(exception.getMessage().toLowerCase().contains("longitude"));
    }
    
    @Test
    void testValidateSigningBasketHeaderWithValidValue() {
        assertTrue(validator.validateSigningBasketHeader("GEO:52.506931;13.144558"));
        assertTrue(validator.validateSigningBasketHeader("GEO:0;0"));
    }
    
    @Test
    void testValidateSigningBasketHeaderWithNull() {
        // For SHOULD requirement, null is acceptable
        assertTrue(validator.validateSigningBasketHeader(null));
    }
    
    @Test
    void testValidateSigningBasketHeaderWithEmpty() {
        // For SHOULD requirement, empty is acceptable
        assertTrue(validator.validateSigningBasketHeader(""));
        assertTrue(validator.validateSigningBasketHeader("   "));
    }
    
    @Test
    void testValidateSigningBasketHeaderWithInvalidValue() {
        // If provided, must be valid
        assertFalse(validator.validateSigningBasketHeader("invalid"));
        assertFalse(validator.validateSigningBasketHeader("GEO:100;0"));
        assertFalse(validator.validateSigningBasketHeader("52.506931;13.144558"));
    }
    
    @Test
    void testGetValidationErrorMessage() {
        // Valid input should return null
        assertNull(validator.getValidationErrorMessage("GEO:52.506931;13.144558"));
        
        // Invalid input should return error message
        assertNotNull(validator.getValidationErrorMessage(null));
        assertNotNull(validator.getValidationErrorMessage(""));
        assertNotNull(validator.getValidationErrorMessage("invalid"));
        assertNotNull(validator.getValidationErrorMessage("GEO:100;0"));
    }
}
