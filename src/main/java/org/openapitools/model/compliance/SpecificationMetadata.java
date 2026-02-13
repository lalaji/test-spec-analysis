package org.openapitools.model.compliance;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Complete metadata for a specification including license, attribution, and change tracking
 */
public class SpecificationMetadata {

    @JsonProperty("specificationId")
    private String specificationId;

    @JsonProperty("specificationName")
    private String specificationName;

    @JsonProperty("version")
    private String version;

    @JsonProperty("description")
    private String description;

    @JsonProperty("license")
    private LicenseInfo license;

    @JsonProperty("attribution")
    private AttributionInfo attribution;

    @JsonProperty("changes")
    private List<SpecificationChange> changes = new ArrayList<>();

    @JsonProperty("originalSourceUrl")
    private String originalSourceUrl;

    @JsonProperty("redistributionAllowed")
    private Boolean redistributionAllowed;

    public SpecificationMetadata() {
    }

    public String getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(String specificationId) {
        this.specificationId = specificationId;
    }

    public String getSpecificationName() {
        return specificationName;
    }

    public void setSpecificationName(String specificationName) {
        this.specificationName = specificationName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LicenseInfo getLicense() {
        return license;
    }

    public void setLicense(LicenseInfo license) {
        this.license = license;
    }

    public AttributionInfo getAttribution() {
        return attribution;
    }

    public void setAttribution(AttributionInfo attribution) {
        this.attribution = attribution;
    }

    public List<SpecificationChange> getChanges() {
        return changes;
    }

    public void setChanges(List<SpecificationChange> changes) {
        this.changes = changes;
    }

    public String getOriginalSourceUrl() {
        return originalSourceUrl;
    }

    public void setOriginalSourceUrl(String originalSourceUrl) {
        this.originalSourceUrl = originalSourceUrl;
    }

    public Boolean getRedistributionAllowed() {
        return redistributionAllowed;
    }

    public void setRedistributionAllowed(Boolean redistributionAllowed) {
        this.redistributionAllowed = redistributionAllowed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecificationMetadata that = (SpecificationMetadata) o;
        return Objects.equals(specificationId, that.specificationId) &&
                Objects.equals(specificationName, that.specificationName) &&
                Objects.equals(version, that.version) &&
                Objects.equals(description, that.description) &&
                Objects.equals(license, that.license) &&
                Objects.equals(attribution, that.attribution) &&
                Objects.equals(changes, that.changes) &&
                Objects.equals(originalSourceUrl, that.originalSourceUrl) &&
                Objects.equals(redistributionAllowed, that.redistributionAllowed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specificationId, specificationName, version, description, license, 
                           attribution, changes, originalSourceUrl, redistributionAllowed);
    }

    @Override
    public String toString() {
        return "SpecificationMetadata{" +
                "specificationId='" + specificationId + '\'' +
                ", specificationName='" + specificationName + '\'' +
                ", version='" + version + '\'' +
                ", description='" + description + '\'' +
                ", license=" + license +
                ", attribution=" + attribution +
                ", changes=" + changes +
                ", originalSourceUrl='" + originalSourceUrl + '\'' +
                ", redistributionAllowed=" + redistributionAllowed +
                '}';
    }
}
