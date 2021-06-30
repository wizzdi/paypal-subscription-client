
package com.wizzdi.billing.payment.paypal.client.response;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "plan_id",
    "start_time",
    "subscriber",
    "create_time",
    "status",
    "status_update_time"
})

public class Subscription {

    @JsonProperty("id")
    private String id;
    @JsonProperty("plan_id")
    private String planId;
    @JsonProperty("start_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime startTime;
    @JsonProperty("subscriber")
    private Subscriber subscriber;
    @JsonProperty("create_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String createTime;
    @JsonProperty("status")
    private String status;
    @JsonProperty("status_update_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime statusUpdateTime;
    private List<Link> links=new ArrayList<>();
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

    @JsonProperty("create_time")
    public String getCreateTime() {
        return createTime;
    }

    @JsonProperty("create_time")
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("status_update_time")
    public OffsetDateTime getStatusUpdateTime() {
        return statusUpdateTime;
    }

    @JsonProperty("status_update_time")
    public void setStatusUpdateTime(OffsetDateTime statusUpdateTime) {
        this.statusUpdateTime = statusUpdateTime;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public List<Link> getLinks() {
        return links;
    }

    public <T extends Subscription> T setLinks(List<Link> links) {
        this.links = links;
        return (T) this;
    }
}
