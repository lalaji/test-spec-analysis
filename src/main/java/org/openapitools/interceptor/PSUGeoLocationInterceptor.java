package org.openapitools.interceptor;

import org.openapitools.validation.PSUGeoLocationHeaderValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Interceptor to validate PSU-GEO-Location header for consent and signing basket requests.
 * Implements Berlin Group compliance for geographical coordinate validation.
 */
@Component
public class PSUGeoLocationInterceptor implements HandlerInterceptor {
    
    private static final Logger logger = LoggerFactory.getLogger(PSUGeoLocationInterceptor.class);
    private static final String PSU_GEO_LOCATION_HEADER = "PSU-Geo-Location";
    
    @Autowired
    private PSUGeoLocationHeaderValidator validator;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
            throws Exception {
        
        String requestPath = request.getRequestURI();
        
        // Check if this is a consent creation or signing basket request
        if (shouldValidateGeoLocation(requestPath)) {
            String psuGeoLocation = request.getHeader(PSU_GEO_LOCATION_HEADER);
            
            // For signing basket requests, the header is SHOULD (recommended) not MUST
            boolean isSigningBasket = isSigningBasketRequest(requestPath);
            
            if (isSigningBasket) {
                // For signing basket, validate only if provided
                if (!validator.validateSigningBasketHeader(psuGeoLocation)) {
                    logger.warn("Invalid PSU-GEO-Location header in signing basket request: {}", 
                            validator.getValidationErrorMessage(psuGeoLocation));
                    sendErrorResponse(response, 400, 
                            validator.getValidationErrorMessage(psuGeoLocation));
                    return false;
                }
            } else {
                // For other consent operations, validate strictly
                try {
                    validator.validateHeader(psuGeoLocation);
                } catch (IllegalArgumentException e) {
                    logger.warn("Invalid PSU-GEO-Location header: {}", e.getMessage());
                    sendErrorResponse(response, 400, e.getMessage());
                    return false;
                }
            }
        }
        
        return true;
    }
    
    /**
     * Determines if the request path requires PSU-GEO-Location validation.
     */
    private boolean shouldValidateGeoLocation(String requestPath) {
        return requestPath.contains("/pre-process-consent-creation") ||
               requestPath.contains("/validate-consent-access") ||
               requestPath.contains("/signing-basket") ||
               requestPath.contains("/persist-authorized-consent");
    }
    
    /**
     * Determines if this is a signing basket request.
     */
    private boolean isSigningBasketRequest(String requestPath) {
        return requestPath.contains("/signing-basket");
    }
    
    /**
     * Sends an error response with the given status code and message.
     */
    private void sendErrorResponse(HttpServletResponse response, int statusCode, String message) 
            throws IOException {
        response.setStatus(statusCode);
        response.setContentType("application/json");
        response.getWriter().write(String.format(
                "{\"status\":\"ERROR\",\"errorMessage\":\"invalid_header\",\"errorDescription\":\"%s\"}", 
                message));
    }
}
