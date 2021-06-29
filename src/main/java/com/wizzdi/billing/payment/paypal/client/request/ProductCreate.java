
package com.wizzdi.billing.payment.paypal.client.request;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "description",
    "type",
    "category",
    "image_url",
    "home_url"
})

public class ProductCreate {

    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("type")
    private ProductType type;
    @JsonProperty("category")
    private ProductCategory category;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("home_url")
    private String homeUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("type")
    public ProductType getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(ProductType type) {
        this.type = type;
    }

    @JsonProperty("category")
    public ProductCategory getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    @JsonProperty("image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("image_url")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("home_url")
    public String getHomeUrl() {
        return homeUrl;
    }

    @JsonProperty("home_url")
    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
