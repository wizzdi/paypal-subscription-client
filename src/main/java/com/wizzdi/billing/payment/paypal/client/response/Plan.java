
package com.wizzdi.billing.payment.paypal.client.response;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "product_id",
    "name",
    "status",
    "description",
    "billing_cycles",
    "payment_preferences",
    "taxes",
    "quantity_supported",
    "create_time",
    "update_time"
})

public class Plan {

    @JsonProperty("id")
    private String id;
    @JsonProperty("product_id")
    private String productId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("status")
    private PlanStatus status;
    @JsonProperty("description")
    private String description;
    @JsonProperty("billing_cycles")
    private List<BillingCycle> billingCycles = null;
    @JsonProperty("payment_preferences")
    private PaymentPreferences paymentPreferences;
    @JsonProperty("taxes")
    private Taxes taxes;
    @JsonProperty("quantity_supported")
    private Boolean quantitySupported;
    @JsonProperty("create_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createTime;
    @JsonProperty("update_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime updateTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("product_id")
    public String getProductId() {
        return productId;
    }

    @JsonProperty("product_id")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("status")
    public PlanStatus getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(PlanStatus status) {
        this.status = status;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("billing_cycles")
    public List<BillingCycle> getBillingCycles() {
        return billingCycles;
    }

    @JsonProperty("billing_cycles")
    public void setBillingCycles(List<BillingCycle> billingCycles) {
        this.billingCycles = billingCycles;
    }

    @JsonProperty("payment_preferences")
    public PaymentPreferences getPaymentPreferences() {
        return paymentPreferences;
    }

    @JsonProperty("payment_preferences")
    public void setPaymentPreferences(PaymentPreferences paymentPreferences) {
        this.paymentPreferences = paymentPreferences;
    }

    @JsonProperty("taxes")
    public Taxes getTaxes() {
        return taxes;
    }

    @JsonProperty("taxes")
    public void setTaxes(Taxes taxes) {
        this.taxes = taxes;
    }

    @JsonProperty("quantity_supported")
    public Boolean getQuantitySupported() {
        return quantitySupported;
    }

    @JsonProperty("quantity_supported")
    public void setQuantitySupported(Boolean quantitySupported) {
        this.quantitySupported = quantitySupported;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    @Override
    public String toString() {
        return "Plan{" +
                "id='" + id + '\'' +
                ", productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", billingCycles=" + billingCycles +
                ", paymentPreferences=" + paymentPreferences +
                ", taxes=" + taxes +
                ", quantitySupported=" + quantitySupported +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
