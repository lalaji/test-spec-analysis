package org.openapitools.service;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Service for validating ISO 20022 pain.001.001.03 XML messages for SEPA credit transfers
 */
@Service
public class ISO20022ValidationService {
    
    private static final String SCHEMA_PATH = "/schemas/pain.001.001.03.xsd";
    private static final String EXPECTED_NAMESPACE = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03";
    
    private final Schema schema;
    
    public ISO20022ValidationService() {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            InputStream schemaStream = getClass().getResourceAsStream(SCHEMA_PATH);
            if (schemaStream == null) {
                throw new IllegalStateException("ISO 20022 schema not found: " + SCHEMA_PATH);
            }
            this.schema = factory.newSchema(new StreamSource(schemaStream));
        } catch (SAXException e) {
            throw new IllegalStateException("Failed to load ISO 20022 schema", e);
        }
    }
    
    /**
     * Validates an XML string against the ISO 20022 pain.001.001.03 schema
     * 
     * @param xmlContent the XML content to validate
     * @return ValidationResult containing validation status and any error messages
     */
    public ValidationResult validate(String xmlContent) {
        List<String> errors = new ArrayList<>();
        
        if (xmlContent == null || xmlContent.trim().isEmpty()) {
            errors.add("XML content is empty");
            return new ValidationResult(false, errors);
        }
        
        // Check for required namespace
        if (!xmlContent.contains(EXPECTED_NAMESPACE)) {
            errors.add("XML does not contain the required ISO 20022 namespace: " + EXPECTED_NAMESPACE);
            return new ValidationResult(false, errors);
        }
        
        try {
            Validator validator = schema.newValidator();
            ValidationErrorHandler errorHandler = new ValidationErrorHandler();
            validator.setErrorHandler(errorHandler);
            
            ByteArrayInputStream inputStream = new ByteArrayInputStream(
                xmlContent.getBytes(StandardCharsets.UTF_8)
            );
            validator.validate(new StreamSource(inputStream));
            
            if (errorHandler.hasErrors()) {
                errors.addAll(errorHandler.getErrors());
                return new ValidationResult(false, errors);
            }
            
            return new ValidationResult(true, errors);
            
        } catch (SAXException e) {
            errors.add("XML parsing error: " + e.getMessage());
            return new ValidationResult(false, errors);
        } catch (IOException e) {
            errors.add("I/O error during validation: " + e.getMessage());
            return new ValidationResult(false, errors);
        } catch (Exception e) {
            errors.add("Unexpected error during validation: " + e.getMessage());
            return new ValidationResult(false, errors);
        }
    }
    
    /**
     * Result of XML validation
     */
    public static class ValidationResult {
        private final boolean valid;
        private final List<String> errors;
        
        public ValidationResult(boolean valid, List<String> errors) {
            this.valid = valid;
            this.errors = errors;
        }
        
        public boolean isValid() {
            return valid;
        }
        
        public List<String> getErrors() {
            return errors;
        }
    }
}
