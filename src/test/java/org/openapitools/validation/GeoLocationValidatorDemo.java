package org.openapitools.validation;

/**
 * Manual demonstration of GeoLocationValidator functionality.
 * Run this class to verify validation behavior with various coordinate inputs.
 */
public class GeoLocationValidatorDemo {
    
    public static void main(String[] args) {
        System.out.println("Testing GeoLocationValidator...\n");
        
        // Test valid coordinates
        testValidation("GEO:52.506931;13.144558", true, "Berlin coordinates");
        testValidation("GEO:0;0", true, "Equator and Prime Meridian");
        testValidation("GEO:90;180", true, "Maximum values");
        testValidation("GEO:-90;-180", true, "Minimum values");
        
        // Test invalid formats
        testValidation("52.506931;13.144558", false, "Missing GEO prefix");
        testValidation("GEO:abc;def", false, "Invalid characters");
        testValidation(null, false, "Null value");
        testValidation("", false, "Empty string");
        
        // Test invalid coordinates
        testValidation("GEO:100;0", false, "Invalid latitude > 90");
        testValidation("GEO:-100;0", false, "Invalid latitude < -90");
        testValidation("GEO:0;200", false, "Invalid longitude > 180");
        testValidation("GEO:0;-200", false, "Invalid longitude < -180");
        
        System.out.println("\nAll tests completed!");
    }
    
    private static void testValidation(String input, boolean expectedValid, String description) {
        boolean isValid = GeoLocationValidator.isValid(input);
        String status = (isValid == expectedValid) ? "✓ PASS" : "✗ FAIL";
        System.out.printf("%s - %s: %s (expected: %s, got: %s)%n", 
            status, description, 
            (input == null ? "null" : input), 
            expectedValid, isValid);
        
        if (isValid != expectedValid) {
            System.out.println("  Error: " + GeoLocationValidator.getValidationError(input));
        }
    }
}
