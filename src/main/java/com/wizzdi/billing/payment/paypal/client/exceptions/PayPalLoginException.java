package com.wizzdi.billing.payment.paypal.client.exceptions;

public class PayPalLoginException extends Exception {

    public PayPalLoginException() {
    }

    public PayPalLoginException(String message) {
        super(message);
    }

    public PayPalLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public PayPalLoginException(Throwable cause) {
        super(cause);
    }

    public PayPalLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
