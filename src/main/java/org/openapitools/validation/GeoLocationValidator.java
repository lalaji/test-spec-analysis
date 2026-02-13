package org.openapitools.validation;

import java.util.regex.Pattern;

/**
 * Validator for PSU-GEO-Location header according to Berlin Group specifications.
 * 
 * The PSU-GEO-Location header should contain geographical coordinates in the format:
 * "GEO:latitude;longitude"
 * 
 * Where:
 * - latitude is a decimal number between -90 and 90
 * - longitude is a decimal number between -180 and 180
 * 
 * Example: "GEO:52.506931;13.144558"
 */
public class GeoLocationValidator {
    
    // Pattern to match geographical coordinates in the format GEO:latitude;longitude
    private static final Pattern GEO_PATTERN = Pattern.compile(
        "^GEO:(-?\\d+(\\.\\d+)?);(-?\\d+(\\.\\d+)?)$",
        Pattern.CASE_INSENSITIVE
    );
    
    /**
     * Validates if the PSU-GEO-Location header value is in the correct format
     * and contains valid geographical coordinates.
     * 
     * @param geoLocation the PSU-GEO-Location header value
     * @return true if valid, false otherwise
     */
    public static boolean isValid(String geoLocation) {
        if (geoLocation == null || geoLocation.trim().isEmpty()) {
            return false;
        }
        
        if (!GEO_PATTERN.matcher(geoLocation).matches()) {
            return false;
        }
        
        try {
            String[] parts = geoLocation.substring(4).split(";");
            double latitude = Double.parseDouble(parts[0]);
            double longitude = Double.parseDouble(parts[1]);
            
            return isValidLatitude(latitude) && isValidLongitude(longitude);
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Validates latitude value.
     * 
     * @param latitude the latitude value
     * @return true if latitude is between -90 and 90
     */
    private static boolean isValidLatitude(double latitude) {
        return latitude >= -90.0 && latitude <= 90.0;
    }
    
    /**
     * Validates longitude value.
     * 
     * @param longitude the longitude value
     * @return true if longitude is between -180 and 180
     */
    private static boolean isValidLongitude(double longitude) {
        return longitude >= -180.0 && longitude <= 180.0;
    }
    
    /**
     * Gets a validation error message for an invalid PSU-GEO-Location header.
     * 
     * @param geoLocation the PSU-GEO-Location header value
     * @return error message describing why the value is invalid
     */
    public static String getValidationError(String geoLocation) {
        if (geoLocation == null || geoLocation.trim().isEmpty()) {
            return "PSU-GEO-Location header is required and cannot be empty";
        }
        
        if (!geoLocation.toUpperCase().startsWith("GEO:")) {
            return "PSU-GEO-Location header must start with 'GEO:' prefix";
        }
        
        if (!GEO_PATTERN.matcher(geoLocation).matches()) {
            return "PSU-GEO-Location header must be in format 'GEO:latitude;longitude'";
        }
        
        try {
            String[] parts = geoLocation.substring(4).split(";");
            double latitude = Double.parseDouble(parts[0]);
            double longitude = Double.parseDouble(parts[1]);
            
            if (!isValidLatitude(latitude)) {
                return "Latitude must be between -90 and 90 degrees";
            }
            
            if (!isValidLongitude(longitude)) {
                return "Longitude must be between -180 and 180 degrees";
            }
        } catch (Exception e) {
            return "Invalid coordinate format in PSU-GEO-Location header";
        }
        
        return null;
    }
}
