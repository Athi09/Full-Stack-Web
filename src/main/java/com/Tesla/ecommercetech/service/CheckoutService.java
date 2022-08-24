package com.Tesla.ecommercetech.service;

import com.Tesla.ecommercetech.dto.PaymentInfo;
import com.Tesla.ecommercetech.dto.Purchase;
import com.Tesla.ecommercetech.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);

    PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;

}
