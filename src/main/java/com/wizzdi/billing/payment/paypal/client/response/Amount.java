package com.wizzdi.billing.payment.paypal.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Amount {

    @JsonProperty("currency_code")
    private String currencyCode;

    private String value;


    @JsonProperty("currency_code")
    public String getCurrencyCode() {
        return currencyCode;
    }

    public <T extends Amount> T setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return (T) this;
    }

    public String getValue() {
        return value;
    }

    public <T extends Amount> T setValue(String value) {
        this.value = value;
        return (T) this;
    }
}
