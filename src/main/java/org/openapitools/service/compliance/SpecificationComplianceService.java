package org.openapitools.service.compliance;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.openapitools.model.compliance.SpecificationMetadata;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Service for managing specification metadata, licenses, and attribution information.
 * Implements REQ_0014 compliance for specification redistribution.
 */
@Service
public class SpecificationComplianceService {

    private static final Logger logger = Logger.getLogger(SpecificationComplianceService.class.getName());
    
    private final Map<String, SpecificationMetadata> specifications = new HashMap<>();
    private final ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());

    @PostConstruct
    public void loadSpecifications() {
        try {
            loadSpecificationMetadata("berlin-group");
        } catch (IOException e) {
            logger.warning("Failed to load specification metadata: " + e.getMessage());
        }
    }

    private void loadSpecificationMetadata(String specId) throws IOException {
        String configPath = "compliance/" + specId + "-metadata.yaml";
        try {
            ClassPathResource resource = new ClassPathResource(configPath);
            if (resource.exists()) {
                try (InputStream is = resource.getInputStream()) {
                    SpecificationMetadata metadata = yamlMapper.readValue(is, SpecificationMetadata.class);
                    specifications.put(specId, metadata);
                    logger.info("Loaded specification metadata for: " + specId);
                }
            }
        } catch (IOException e) {
            logger.warning("Could not load specification metadata from " + configPath + ": " + e.getMessage());
        }
    }

    /**
     * Get metadata for a specific specification
     */
    public SpecificationMetadata getSpecificationMetadata(String specificationId) {
        return specifications.get(specificationId);
    }

    /**
     * Get all registered specifications
     */
    public Map<String, SpecificationMetadata> getAllSpecifications() {
        return new HashMap<>(specifications);
    }

    /**
     * Check if a specification allows commercial redistribution
     */
    public boolean allowsCommercialRedistribution(String specificationId) {
        SpecificationMetadata metadata = specifications.get(specificationId);
        if (metadata == null || metadata.getLicense() == null) {
            return false;
        }
        return Boolean.TRUE.equals(metadata.getLicense().getAllowsCommercialUse());
    }

    /**
     * Check if a specification requires attribution
     */
    public boolean requiresAttribution(String specificationId) {
        SpecificationMetadata metadata = specifications.get(specificationId);
        if (metadata == null || metadata.getLicense() == null) {
            return false;
        }
        return Boolean.TRUE.equals(metadata.getLicense().getRequiresAttribution());
    }

    /**
     * Check if any changes have been made to the specification
     */
    public boolean hasChanges(String specificationId) {
        SpecificationMetadata metadata = specifications.get(specificationId);
        return metadata != null && metadata.getChanges() != null && !metadata.getChanges().isEmpty();
    }
}
