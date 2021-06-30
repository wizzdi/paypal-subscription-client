package com.wizzdi.billing.payment.paypal.client.response;

import org.springframework.http.HttpMethod;

public class Link {
    private String href;
    private String rel;
    private HttpMethod httpMethod;


    public String getHref() {
        return href;
    }

    public <T extends Link> T setHref(String href) {
        this.href = href;
        return (T) this;
    }

    public String getRel() {
        return rel;
    }

    public <T extends Link> T setRel(String rel) {
        this.rel = rel;
        return (T) this;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public <T extends Link> T setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
        return (T) this;
    }
}
