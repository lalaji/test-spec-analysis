package org.openapitools.api;

import org.junit.jupiter.api.Test;
import org.openapitools.model.PaymentValidationResponse;
import org.openapitools.service.ISO20022ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Unit tests for ValidatePaymentInitiationController
 */
@WebMvcTest(ValidatePaymentInitiationController.class)
public class ValidatePaymentInitiationControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private ISO20022ValidationService validationService;
    
    @Test
    public void testValidatePaymentInitiation_ValidXML() throws Exception {
        String validXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                         "<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03\">" +
                         "<CstmrCdtTrfInitn></CstmrCdtTrfInitn></Document>";
        
        ISO20022ValidationService.ValidationResult validResult = 
            new ISO20022ValidationService.ValidationResult(true, new ArrayList<>());
        
        when(validationService.validate(any(String.class))).thenReturn(validResult);
        
        mockMvc.perform(post("/wso2-f5b/OB4/1.0.0/validate-payment-initiation")
                .contentType(MediaType.APPLICATION_XML)
                .content(validXML))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.data.valid").value(true))
                .andExpect(jsonPath("$.data.schema").value("ISO 20022 pain.001.001.03"))
                .andExpect(jsonPath("$.responseId").exists());
    }
    
    @Test
    public void testValidatePaymentInitiation_InvalidXML() throws Exception {
        String invalidXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                           "<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03\">" +
                           "<InvalidElement/></Document>";
        
        ISO20022ValidationService.ValidationResult invalidResult = 
            new ISO20022ValidationService.ValidationResult(false, 
                Arrays.asList("Error at line 1: Invalid element"));
        
        when(validationService.validate(any(String.class))).thenReturn(invalidResult);
        
        mockMvc.perform(post("/wso2-f5b/OB4/1.0.0/validate-payment-initiation")
                .contentType(MediaType.APPLICATION_XML)
                .content(invalidXML))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.data.valid").value(false))
                .andExpect(jsonPath("$.data.validationErrors").isArray())
                .andExpect(jsonPath("$.data.validationErrors[0]").value("Error at line 1: Invalid element"));
    }
    
    @Test
    public void testValidatePaymentInitiation_EmptyXML() throws Exception {
        ISO20022ValidationService.ValidationResult emptyResult = 
            new ISO20022ValidationService.ValidationResult(false, 
                Arrays.asList("XML content is empty"));
        
        when(validationService.validate(any(String.class))).thenReturn(emptyResult);
        
        mockMvc.perform(post("/wso2-f5b/OB4/1.0.0/validate-payment-initiation")
                .contentType(MediaType.APPLICATION_XML)
                .content(""))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.data.valid").value(false))
                .andExpect(jsonPath("$.data.validationErrors[0]").value("XML content is empty"));
    }
}
