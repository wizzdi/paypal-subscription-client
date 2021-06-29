package com.wizzdi.billing.payment.paypal.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PayPalToken {

    private String scope;
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("app_id")
    private String appId;
    @JsonProperty("expires_in")
    private long expiresIn;
    private String nonce;



    public String getScope() {
        return scope;
    }

    public <T extends PayPalToken> T setScope(String scope) {
        this.scope = scope;
        return (T) this;
    }

    @JsonProperty("access_token")

    public String getAccessToken() {
        return accessToken;
    }

    public <T extends PayPalToken> T setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return (T) this;
    }

    @JsonProperty("token_type")

    public String getTokenType() {
        return tokenType;
    }

    public <T extends PayPalToken> T setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return (T) this;
    }

    @JsonProperty("app_id")

    public String getAppId() {
        return appId;
    }

    public <T extends PayPalToken> T setAppId(String appId) {
        this.appId = appId;
        return (T) this;
    }

    @JsonProperty("expires_in")

    public long getExpiresIn() {
        return expiresIn;
    }

    public <T extends PayPalToken> T setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        return (T) this;
    }

    public String getNonce() {
        return nonce;
    }

    public <T extends PayPalToken> T setNonce(String nonce) {
        this.nonce = nonce;
        return (T) this;
    }
}
