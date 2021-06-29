package com.wizzdi.billing.payment.paypal.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class PaginationResponse {

    @JsonProperty("total_items")
    private int totalItems;
    @JsonProperty("total_pages")
    private int totalPages;

    @JsonProperty("total_items")

    public int getTotalItems() {
        return totalItems;
    }

    public <T extends PaginationResponse> T setTotalItems(int totalItems) {
        this.totalItems = totalItems;
        return (T) this;
    }

    @JsonProperty("total_pages")

    public int getTotalPages() {
        return totalPages;
    }

    public <T extends PaginationResponse> T setTotalPages(int totalPages) {
        this.totalPages = totalPages;
        return (T) this;
    }
}
