package com.Tesla.ecommercetech.dto;

import lombok.Data;

@Data
public class PurchaseResponse {    // We will use this class to send back a Java object as JSON

    private final String orderTrackingNumber;

}
