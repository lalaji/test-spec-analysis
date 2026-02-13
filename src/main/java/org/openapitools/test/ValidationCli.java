package org.openapitools.test;

import org.openapitools.service.ISO20022ValidationService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Command-line utility to validate XML files against ISO 20022 pain.001.001.03 schema
 */
public class ValidationCli {
    
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java ValidationCli <xml-file-path>");
            System.exit(1);
        }
        
        String xmlFilePath = args[0];
        
        try {
            String xmlContent = new String(Files.readAllBytes(Paths.get(xmlFilePath)));
            
            System.out.println("Validating: " + xmlFilePath);
            System.out.println("=".repeat(80));
            
            ISO20022ValidationService service = new ISO20022ValidationService();
            ISO20022ValidationService.ValidationResult result = service.validate(xmlContent);
            
            if (result.isValid()) {
                System.out.println("✓ VALID - XML conforms to ISO 20022 pain.001.001.03 schema");
            } else {
                System.out.println("✗ INVALID - XML does not conform to ISO 20022 pain.001.001.03 schema");
                System.out.println("\nValidation Errors:");
                for (String error : result.getErrors()) {
                    System.out.println("  - " + error);
                }
            }
            
            System.out.println("=".repeat(80));
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Validation error: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
