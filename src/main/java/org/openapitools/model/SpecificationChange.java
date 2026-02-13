package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Model representing a change made to a specification
 * Required for Berlin Group REQ_0014 compliance - indicating changes made to redistributed specifications
 */
public class SpecificationChange {
    
    @JsonProperty("changeId")
    private String changeId;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("changedBy")
    private String changedBy;
    
    @JsonProperty("changeDate")
    private OffsetDateTime changeDate;
    
    @JsonProperty("changeType")
    private String changeType;
    
    @JsonProperty("affectedSection")
    private String affectedSection;

    public SpecificationChange() {
    }

    public SpecificationChange changeId(String changeId) {
        this.changeId = changeId;
        return this;
    }

    public String getChangeId() {
        return changeId;
    }

    public void setChangeId(String changeId) {
        this.changeId = changeId;
    }

    public SpecificationChange description(String description) {
        this.description = description;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SpecificationChange changedBy(String changedBy) {
        this.changedBy = changedBy;
        return this;
    }

    public String getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(String changedBy) {
        this.changedBy = changedBy;
    }

    public SpecificationChange changeDate(OffsetDateTime changeDate) {
        this.changeDate = changeDate;
        return this;
    }

    public OffsetDateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(OffsetDateTime changeDate) {
        this.changeDate = changeDate;
    }

    public SpecificationChange changeType(String changeType) {
        this.changeType = changeType;
        return this;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public SpecificationChange affectedSection(String affectedSection) {
        this.affectedSection = affectedSection;
        return this;
    }

    public String getAffectedSection() {
        return affectedSection;
    }

    public void setAffectedSection(String affectedSection) {
        this.affectedSection = affectedSection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecificationChange that = (SpecificationChange) o;
        return Objects.equals(changeId, that.changeId) &&
                Objects.equals(description, that.description) &&
                Objects.equals(changedBy, that.changedBy) &&
                Objects.equals(changeDate, that.changeDate) &&
                Objects.equals(changeType, that.changeType) &&
                Objects.equals(affectedSection, that.affectedSection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(changeId, description, changedBy, changeDate, changeType, affectedSection);
    }

    @Override
    public String toString() {
        return "SpecificationChange{" +
                "changeId='" + changeId + '\'' +
                ", description='" + description + '\'' +
                ", changedBy='" + changedBy + '\'' +
                ", changeDate=" + changeDate +
                ", changeType='" + changeType + '\'' +
                ", affectedSection='" + affectedSection + '\'' +
                '}';
    }
}
