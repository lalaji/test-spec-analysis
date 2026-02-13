package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 */
@Schema(description = "")
public class AmendedAuthorization {

  @Schema(description = "")
  @JsonProperty("id")
  private String id;

  @Schema(description = "")
  @JsonProperty("type")
  private String type;

  @Schema(description = "")
  @JsonProperty("status")
  private String status;

  @Schema(description = "")
  @JsonProperty("resources")
  private List<Resource> resources;

  @Schema(description = "")
  @JsonProperty("amendedResources")
  private List<AmendedResource> amendedResources;

  /**
   * 
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  /**
   * 
   * @return type
   */
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  /**
   * 
   * @return status
   */
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * 
   * @return resources
   */
  public List<Resource> getResources() {
    return resources;
  }

  public void setResources(List<Resource> resources) {
    this.resources = resources;
  }

  /**
   * 
   * @return amendedResources
   */
  public List<AmendedResource> getAmendedResources() {
    return amendedResources;
  }

  public void setAmendedResources(List<AmendedResource> amendedResources) {
    this.amendedResources = amendedResources;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AmendedAuthorization that = (AmendedAuthorization) o;
    return Objects.equals(this.id, that.id) &&
        Objects.equals(this.type, that.type) &&
        Objects.equals(this.status, that.status) &&
        Objects.equals(this.resources, that.resources) &&
        Objects.equals(this.amendedResources, that.amendedResources);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, status, resources, amendedResources);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AmendedAuthorization {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
    sb.append("    amendedResources: ").append(toIndentedString(amendedResources)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}