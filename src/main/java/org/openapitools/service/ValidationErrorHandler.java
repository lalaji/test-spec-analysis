package org.openapitools.service;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom error handler for XML validation that collects all validation errors
 */
public class ValidationErrorHandler implements ErrorHandler {
    
    private final List<String> errors = new ArrayList<>();
    
    @Override
    public void warning(SAXParseException exception) throws SAXException {
        errors.add("Warning at line " + exception.getLineNumber() + ": " + exception.getMessage());
    }
    
    @Override
    public void error(SAXParseException exception) throws SAXException {
        errors.add("Error at line " + exception.getLineNumber() + ": " + exception.getMessage());
    }
    
    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        errors.add("Fatal error at line " + exception.getLineNumber() + ": " + exception.getMessage());
    }
    
    public boolean hasErrors() {
        return !errors.isEmpty();
    }
    
    public List<String> getErrors() {
        return errors;
    }
}
