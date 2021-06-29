package com.wizzdi.billing.payment.paypal.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tier {

    @JsonProperty("starting_quantity")
    private String startingQuantity;
    @JsonProperty("ending_quantity")
    private String endingQuantity;
    private Amount amount;

    @JsonProperty("starting_quantity")

    public String getStartingQuantity() {
        return startingQuantity;
    }

    public <T extends Tier> T setStartingQuantity(String startingQuantity) {
        this.startingQuantity = startingQuantity;
        return (T) this;
    }

    @JsonProperty("ending_quantity")

    public String getEndingQuantity() {
        return endingQuantity;
    }

    public <T extends Tier> T setEndingQuantity(String endingQuantity) {
        this.endingQuantity = endingQuantity;
        return (T) this;
    }

    public Amount getAmount() {
        return amount;
    }

    public <T extends Tier> T setAmount(Amount amount) {
        this.amount = amount;
        return (T) this;
    }
}
