package com.wizzdi.billing.payment.paypal.client.response;

import java.util.List;

public class ProductsResponse extends PaginationResponse{


    private List<Product> products;


    public List<Product> getProducts() {
        return products;
    }

    public <T extends ProductsResponse> T setProducts(List<Product> products) {
        this.products = products;
        return (T) this;
    }


    @Override
    public String toString() {
        return "ProductsResponse{" +
                "products=" + products +
                '}';
    }
}
