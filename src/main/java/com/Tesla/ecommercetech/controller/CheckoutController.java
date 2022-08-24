package com.Tesla.ecommercetech.controller;

import com.Tesla.ecommercetech.dto.PaymentInfo;
import com.Tesla.ecommercetech.dto.Purchase;
import com.Tesla.ecommercetech.dto.PurchaseResponse;
import com.Tesla.ecommercetech.service.CheckoutService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@CrossOrigin("https://localhost:4200")
@RestController // @RestController annotation is a special controller used in REST ful Web services, and it’s the combination of @Controller and @ResponseBody annotation.
@RequestMapping("/api/checkout") // @RequestMapping - It used to map http requests onto specific handlers/ methods
public class CheckoutController {

    private Logger logger = Logger.getLogger(getClass().getName()); // Logger - It allows us to configure internal logging and file logging
    private CheckoutService checkoutService; // Creating an object of the Checkout service

    @Autowired // Used to auto-inject dependencies on our constructor
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase") // @Post Mapping - Handle the post http requests matched with given URI expression
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) { // @RequestBody - maps the HttpRequest body to a transfer or domain object, enabling automatic deserialization of the inbound HttpRequest body onto a Java object

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase); //


        return purchaseResponse;
    }

    @PostMapping("/payment-intent") // @Post Mapping - Handle the post http requests matched with given URI expression
    public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfo paymentInfo) throws StripeException{

        logger.info("paymentInfo.amount: "  + paymentInfo.getAmount()); // using the logger to print amount into the console or terminal
        logger.info("paymentInfo.receipt email" + paymentInfo.getReceiptEmail());  // using the logger to print amount into the console or terminal

        PaymentIntent paymentIntent = checkoutService.createPaymentIntent(paymentInfo); //

        String paymentStr = paymentIntent.toJson();  //

        return new ResponseEntity<>(paymentStr, HttpStatus.OK);

    }



}
