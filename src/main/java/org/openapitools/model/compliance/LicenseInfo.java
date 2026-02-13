package org.openapitools.model.compliance;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Information about the license under which the specification is distributed
 */
public class LicenseInfo {

    @JsonProperty("name")
    private String name;

    @JsonProperty("url")
    private String url;

    @JsonProperty("type")
    private String type;

    @JsonProperty("allowsCommercialUse")
    private Boolean allowsCommercialUse;

    @JsonProperty("requiresAttribution")
    private Boolean requiresAttribution;

    public LicenseInfo() {
    }

    public LicenseInfo(String name, String url, String type, Boolean allowsCommercialUse, Boolean requiresAttribution) {
        this.name = name;
        this.url = url;
        this.type = type;
        this.allowsCommercialUse = allowsCommercialUse;
        this.requiresAttribution = requiresAttribution;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getAllowsCommercialUse() {
        return allowsCommercialUse;
    }

    public void setAllowsCommercialUse(Boolean allowsCommercialUse) {
        this.allowsCommercialUse = allowsCommercialUse;
    }

    public Boolean getRequiresAttribution() {
        return requiresAttribution;
    }

    public void setRequiresAttribution(Boolean requiresAttribution) {
        this.requiresAttribution = requiresAttribution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LicenseInfo that = (LicenseInfo) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(url, that.url) &&
                Objects.equals(type, that.type) &&
                Objects.equals(allowsCommercialUse, that.allowsCommercialUse) &&
                Objects.equals(requiresAttribution, that.requiresAttribution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, type, allowsCommercialUse, requiresAttribution);
    }

    @Override
    public String toString() {
        return "LicenseInfo{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", allowsCommercialUse=" + allowsCommercialUse +
                ", requiresAttribution=" + requiresAttribution +
                '}';
    }
}
