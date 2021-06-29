package com.wizzdi.billing.payment.paypal.client.response;

import java.util.List;

public class PlansResponse extends PaginationResponse{


    private List<Plan> plans;


    public List<Plan> getPlans() {
        return plans;
    }

    public <T extends PlansResponse> T setPlans(List<Plan> plans) {
        this.plans = plans;
        return (T) this;
    }
}
