
package com.wizzdi.billing.payment.paypal.client.response;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fixed_price"
})

public class PricingScheme {

    private Integer version;
    @JsonProperty("pricing_model")
    private PricingModel pricingModel;
    @JsonProperty("fixed_price")
    private FixedPrice fixedPrice;
    private List<Tier> tiers;
    @JsonProperty("create_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createTime;
    @JsonProperty("update_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime updateTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("fixed_price")
    public FixedPrice getFixedPrice() {
        return fixedPrice;
    }

    @JsonProperty("fixed_price")
    public void setFixedPrice(FixedPrice fixedPrice) {
        this.fixedPrice = fixedPrice;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Integer getVersion() {
        return version;
    }

    @JsonProperty("pricing_model")
    public PricingModel getPricingModel() {
        return pricingModel;
    }

    public <T extends PricingScheme> T setPricingModel(PricingModel pricingModel) {
        this.pricingModel = pricingModel;
        return (T) this;
    }

    public <T extends PricingScheme> T setVersion(Integer version) {
        this.version = version;
        return (T) this;
    }

    public List<Tier> getTiers() {
        return tiers;
    }

    public <T extends PricingScheme> T setTiers(List<Tier> tiers) {
        this.tiers = tiers;
        return (T) this;
    }

    @JsonProperty("create_time")
    public OffsetDateTime getCreateTime() {
        return createTime;
    }

    @JsonProperty("create_time")
    public void setCreateTime(OffsetDateTime createTime) {
        this.createTime = createTime;
    }

    @JsonProperty("update_time")
    public OffsetDateTime getUpdateTime() {
        return updateTime;
    }

    @JsonProperty("update_time")
    public void setUpdateTime(OffsetDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
