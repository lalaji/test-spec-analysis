package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Model for specification metadata including licensing and attribution information
 * Required for Berlin Group REQ_0014 compliance
 */
public class SpecificationMetadata {
    
    @JsonProperty("specificationName")
    private String specificationName;
    
    @JsonProperty("version")
    private String version;
    
    @JsonProperty("licenseName")
    private String licenseName;
    
    @JsonProperty("licenseUrl")
    private String licenseUrl;
    
    @JsonProperty("attributionText")
    private String attributionText;
    
    @JsonProperty("changes")
    private List<SpecificationChange> changes = new ArrayList<>();
    
    @JsonProperty("originalSource")
    private String originalSource;
    
    @JsonProperty("redistributionAllowed")
    private Boolean redistributionAllowed;
    
    @JsonProperty("commercialUseAllowed")
    private Boolean commercialUseAllowed;

    public SpecificationMetadata() {
    }

    public SpecificationMetadata specificationName(String specificationName) {
        this.specificationName = specificationName;
        return this;
    }

    public String getSpecificationName() {
        return specificationName;
    }

    public void setSpecificationName(String specificationName) {
        this.specificationName = specificationName;
    }

    public SpecificationMetadata version(String version) {
        this.version = version;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public SpecificationMetadata licenseName(String licenseName) {
        this.licenseName = licenseName;
        return this;
    }

    public String getLicenseName() {
        return licenseName;
    }

    public void setLicenseName(String licenseName) {
        this.licenseName = licenseName;
    }

    public SpecificationMetadata licenseUrl(String licenseUrl) {
        this.licenseUrl = licenseUrl;
        return this;
    }

    public String getLicenseUrl() {
        return licenseUrl;
    }

    public void setLicenseUrl(String licenseUrl) {
        this.licenseUrl = licenseUrl;
    }

    public SpecificationMetadata attributionText(String attributionText) {
        this.attributionText = attributionText;
        return this;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public SpecificationMetadata changes(List<SpecificationChange> changes) {
        this.changes = changes;
        return this;
    }

    public SpecificationMetadata addChangesItem(SpecificationChange changesItem) {
        if (this.changes == null) {
            this.changes = new ArrayList<>();
        }
        this.changes.add(changesItem);
        return this;
    }

    public List<SpecificationChange> getChanges() {
        return changes;
    }

    public void setChanges(List<SpecificationChange> changes) {
        this.changes = changes;
    }

    public SpecificationMetadata originalSource(String originalSource) {
        this.originalSource = originalSource;
        return this;
    }

    public String getOriginalSource() {
        return originalSource;
    }

    public void setOriginalSource(String originalSource) {
        this.originalSource = originalSource;
    }

    public SpecificationMetadata redistributionAllowed(Boolean redistributionAllowed) {
        this.redistributionAllowed = redistributionAllowed;
        return this;
    }

    public Boolean getRedistributionAllowed() {
        return redistributionAllowed;
    }

    public void setRedistributionAllowed(Boolean redistributionAllowed) {
        this.redistributionAllowed = redistributionAllowed;
    }

    public SpecificationMetadata commercialUseAllowed(Boolean commercialUseAllowed) {
        this.commercialUseAllowed = commercialUseAllowed;
        return this;
    }

    public Boolean getCommercialUseAllowed() {
        return commercialUseAllowed;
    }

    public void setCommercialUseAllowed(Boolean commercialUseAllowed) {
        this.commercialUseAllowed = commercialUseAllowed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecificationMetadata that = (SpecificationMetadata) o;
        return Objects.equals(specificationName, that.specificationName) &&
                Objects.equals(version, that.version) &&
                Objects.equals(licenseName, that.licenseName) &&
                Objects.equals(licenseUrl, that.licenseUrl) &&
                Objects.equals(attributionText, that.attributionText) &&
                Objects.equals(changes, that.changes) &&
                Objects.equals(originalSource, that.originalSource) &&
                Objects.equals(redistributionAllowed, that.redistributionAllowed) &&
                Objects.equals(commercialUseAllowed, that.commercialUseAllowed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specificationName, version, licenseName, licenseUrl, 
                attributionText, changes, originalSource, redistributionAllowed, commercialUseAllowed);
    }

    @Override
    public String toString() {
        return "SpecificationMetadata{" +
                "specificationName='" + specificationName + '\'' +
                ", version='" + version + '\'' +
                ", licenseName='" + licenseName + '\'' +
                ", licenseUrl='" + licenseUrl + '\'' +
                ", attributionText='" + attributionText + '\'' +
                ", changes=" + changes +
                ", originalSource='" + originalSource + '\'' +
                ", redistributionAllowed=" + redistributionAllowed +
                ", commercialUseAllowed=" + commercialUseAllowed +
                '}';
    }
}
