
package com.wizzdi.billing.payment.paypal.client.request;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.*;
import com.wizzdi.billing.payment.paypal.client.response.Subscriber;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "plan_id",
    "start_time",
    "subscriber",
    "application_context"
})

public class SubscriptionCreate {

    @JsonProperty("plan_id")
    private String planId;
    @JsonProperty("start_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime startTime;
    @JsonProperty("subscriber")
    private Subscriber subscriber;
    @JsonProperty("application_context")
    private ApplicationContext applicationContext;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("plan_id")
    public String getPlanId() {
        return planId;
    }

    @JsonProperty("plan_id")
    public void setPlanId(String planId) {
        this.planId = planId;
    }

    @JsonProperty("start_time")
    public OffsetDateTime getStartTime() {
        return startTime;
    }

    @JsonProperty("start_time")
    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    @JsonProperty("subscriber")
    public Subscriber getSubscriber() {
        return subscriber;
    }

    @JsonProperty("subscriber")
    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    @JsonProperty("application_context")
    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @JsonProperty("application_context")
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
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
