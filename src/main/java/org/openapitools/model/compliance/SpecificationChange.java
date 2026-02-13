package org.openapitools.model.compliance;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Information about changes made to the specification
 */
public class SpecificationChange {

    @JsonProperty("changeDate")
    private String changeDate;

    @JsonProperty("changeDescription")
    private String changeDescription;

    @JsonProperty("changeAuthor")
    private String changeAuthor;

    @JsonProperty("changeType")
    private String changeType;

    public SpecificationChange() {
    }

    public SpecificationChange(String changeDate, String changeDescription, String changeAuthor, String changeType) {
        this.changeDate = changeDate;
        this.changeDescription = changeDescription;
        this.changeAuthor = changeAuthor;
        this.changeType = changeType;
    }

    public String getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate;
    }

    public String getChangeDescription() {
        return changeDescription;
    }

    public void setChangeDescription(String changeDescription) {
        this.changeDescription = changeDescription;
    }

    public String getChangeAuthor() {
        return changeAuthor;
    }

    public void setChangeAuthor(String changeAuthor) {
        this.changeAuthor = changeAuthor;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecificationChange that = (SpecificationChange) o;
        return Objects.equals(changeDate, that.changeDate) &&
                Objects.equals(changeDescription, that.changeDescription) &&
                Objects.equals(changeAuthor, that.changeAuthor) &&
                Objects.equals(changeType, that.changeType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(changeDate, changeDescription, changeAuthor, changeType);
    }

    @Override
    public String toString() {
        return "SpecificationChange{" +
                "changeDate='" + changeDate + '\'' +
                ", changeDescription='" + changeDescription + '\'' +
                ", changeAuthor='" + changeAuthor + '\'' +
                ", changeType='" + changeType + '\'' +
                '}';
    }
}
