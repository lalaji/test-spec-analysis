package org.openapitools.model.compliance;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Attribution information for the specification
 */
public class AttributionInfo {

    @JsonProperty("organizationName")
    private String organizationName;

    @JsonProperty("organizationUrl")
    private String organizationUrl;

    @JsonProperty("specificationName")
    private String specificationName;

    @JsonProperty("attributionText")
    private String attributionText;

    public AttributionInfo() {
    }

    public AttributionInfo(String organizationName, String organizationUrl, String specificationName, String attributionText) {
        this.organizationName = organizationName;
        this.organizationUrl = organizationUrl;
        this.specificationName = specificationName;
        this.attributionText = attributionText;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationUrl() {
        return organizationUrl;
    }

    public void setOrganizationUrl(String organizationUrl) {
        this.organizationUrl = organizationUrl;
    }

    public String getSpecificationName() {
        return specificationName;
    }

    public void setSpecificationName(String specificationName) {
        this.specificationName = specificationName;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributionInfo that = (AttributionInfo) o;
        return Objects.equals(organizationName, that.organizationName) &&
                Objects.equals(organizationUrl, that.organizationUrl) &&
                Objects.equals(specificationName, that.specificationName) &&
                Objects.equals(attributionText, that.attributionText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationName, organizationUrl, specificationName, attributionText);
    }

    @Override
    public String toString() {
        return "AttributionInfo{" +
                "organizationName='" + organizationName + '\'' +
                ", organizationUrl='" + organizationUrl + '\'' +
                ", specificationName='" + specificationName + '\'' +
                ", attributionText='" + attributionText + '\'' +
                '}';
    }
}
