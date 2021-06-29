
package com.wizzdi.billing.payment.paypal.client.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.wizzdi.billing.payment.paypal.client.response.BillingCycle;
import com.wizzdi.billing.payment.paypal.client.response.PaymentPreferences;
import com.wizzdi.billing.payment.paypal.client.response.PlanStatus;
import com.wizzdi.billing.payment.paypal.client.response.Taxes;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "product_id",
    "name",
    "description",
    "status",
    "billing_cycles",
    "payment_preferences",
    "taxes"
})
@Generated("jsonschema2pojo")
public class PlanCreate {

    @JsonProperty("product_id")
    private String productId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("status")
    private PlanStatus status;
    @JsonProperty("billing_cycles")
    private List<BillingCycle> billingCycles = null;
    @JsonProperty("payment_preferences")
    private PaymentPreferences paymentPreferences;
    @JsonProperty("taxes")
    private Taxes taxes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("status")
    public PlanStatus getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(PlanStatus status) {
        this.status = status;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
