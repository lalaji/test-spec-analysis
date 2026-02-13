package org.openapitools.validation;

import org.springframework.stereotype.Component;

/**
 * Service for validating PSU-GEO-Location header in consent and signing basket requests.
 * This service implements Berlin Group compliance for geographical coordinate validation.
 */
@Component
public class PSUGeoLocationHeaderValidator {
    
    /**
     * Validates the PSU-GEO-Location header with strict validation (MUST requirement).
     * Use this method for endpoints where the header is mandatory.
     * For signing basket requests (SHOULD requirement), use validateSigningBasketHeader() instead.
     * 
     * @param psuGeoLocation the value of PSU-GEO-Location header
     * @throws IllegalArgumentException if the header is missing or invalid
     */
    public void validateHeader(String psuGeoLocation) {
        if (psuGeoLocation == null || psuGeoLocation.trim().isEmpty()) {
            throw new IllegalArgumentException("PSU-GEO-Location header is required for Berlin Group compliance");
        }
        
        if (!GeoLocationValidator.isValid(psuGeoLocation)) {
            String errorMessage = GeoLocationValidator.getValidationError(psuGeoLocation);
            throw new IllegalArgumentException(errorMessage);
        }
    }
    
    /**
     * Validates the PSU-GEO-Location header for signing basket requests.
     * This is a SHOULD requirement in Berlin Group specification.
     * 
     * @param psuGeoLocation the value of PSU-GEO-Location header
     * @return true if valid or empty (since it's SHOULD, not MUST), false if invalid format
     */
    public boolean validateSigningBasketHeader(String psuGeoLocation) {
        // If not provided, it's acceptable (SHOULD requirement)
        if (psuGeoLocation == null || psuGeoLocation.trim().isEmpty()) {
            return true;
        }
        
        // If provided, it must be valid
        return GeoLocationValidator.isValid(psuGeoLocation);
    }
    
    /**
     * Gets validation error message for invalid PSU-GEO-Location header.
     * 
     * @param psuGeoLocation the value of PSU-GEO-Location header
     * @return error message or null if valid
     */
    public String getValidationErrorMessage(String psuGeoLocation) {
        return GeoLocationValidator.getValidationError(psuGeoLocation);
    }
}
