package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Response for payment initiation validation
 */
public class PaymentValidationResponse {
    
    @JsonProperty("responseId")
    private String responseId;
    
    @JsonProperty("status")
    private String status;
    
    @JsonProperty("data")
    private ValidationData data;
    
    @JsonProperty("errorCode")
    private String errorCode;
    
    @JsonProperty("errorMessage")
    private String errorMessage;
    
    public PaymentValidationResponse() {
    }
    
    public PaymentValidationResponse(String responseId, String status) {
        this.responseId = responseId;
        this.status = status;
    }
    
    public String getResponseId() {
        return responseId;
    }
    
    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public ValidationData getData() {
        return data;
    }
    
    public void setData(ValidationData data) {
        this.data = data;
    }
    
    public String getErrorCode() {
        return errorCode;
    }
    
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    /**
     * Validation data for the payment XML
     */
    public static class ValidationData {
        
        @JsonProperty("valid")
        private boolean valid;
        
        @JsonProperty("validationErrors")
        private List<String> validationErrors;
        
        @JsonProperty("schema")
        private String schema;
        
        public ValidationData() {
        }
        
        public ValidationData(boolean valid, List<String> validationErrors) {
            this.valid = valid;
            this.validationErrors = validationErrors;
            this.schema = "ISO 20022 pain.001.001.03";
        }
        
        public boolean isValid() {
            return valid;
        }
        
        public void setValid(boolean valid) {
            this.valid = valid;
        }
        
        public List<String> getValidationErrors() {
            return validationErrors;
        }
        
        public void setValidationErrors(List<String> validationErrors) {
            this.validationErrors = validationErrors;
        }
        
        public String getSchema() {
            return schema;
        }
        
        public void setSchema(String schema) {
            this.schema = schema;
        }
    }
}
