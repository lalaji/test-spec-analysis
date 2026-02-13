package org.openapitools.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.openapitools.model.PaymentValidationResponse;
import org.openapitools.service.ISO20022ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Controller for validating ISO 20022 pain.001.001.03 payment initiation XML
 */
@RestController
@RequestMapping("/wso2-f5b/OB4/1.0.0")
@Tag(name = "Payment", description = "APIs for payment initiation validation")
public class ValidatePaymentInitiationController {
    
    private final ISO20022ValidationService validationService;
    
    @Autowired
    public ValidatePaymentInitiationController(ISO20022ValidationService validationService) {
        this.validationService = validationService;
    }
    
    @Operation(
        operationId = "validatePaymentInitiation",
        summary = "Validate ISO 20022 pain.001.001.03 payment initiation XML",
        description = "Validates a SEPA credit transfer payment initiation request against ISO 20022 pain.001.001.03 schema",
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "Validation completed (check 'valid' field in response data)",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = PaymentValidationResponse.class)
                )
            ),
            @ApiResponse(
                responseCode = "400", 
                description = "Bad Request - Invalid input",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = PaymentValidationResponse.class)
                )
            ),
            @ApiResponse(
                responseCode = "500", 
                description = "Server Error",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = PaymentValidationResponse.class)
                )
            )
        }
    )
    @PostMapping(
        value = "/validate-payment-initiation",
        consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE},
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PaymentValidationResponse> validatePaymentInitiation(
            @RequestBody String xmlContent) {
        
        String responseId = UUID.randomUUID().toString();
        
        try {
            ISO20022ValidationService.ValidationResult result = validationService.validate(xmlContent);
            
            PaymentValidationResponse response = new PaymentValidationResponse(responseId, "SUCCESS");
            PaymentValidationResponse.ValidationData data = 
                new PaymentValidationResponse.ValidationData(result.isValid(), result.getErrors());
            response.setData(data);
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            PaymentValidationResponse response = new PaymentValidationResponse(responseId, "ERROR");
            response.setErrorCode("VALIDATION_ERROR");
            response.setErrorMessage("Unexpected error during validation: " + e.getMessage());
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
