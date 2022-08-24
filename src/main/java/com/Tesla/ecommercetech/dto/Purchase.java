package com.Tesla.ecommercetech.dto;

import com.Tesla.ecommercetech.enity.Address;
import com.Tesla.ecommercetech.enity.Customer;
import com.Tesla.ecommercetech.enity.Order;
import com.Tesla.ecommercetech.enity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;

    private Address shippingAddress;

    private Address billingAddress;

    private Order order;

    private Set<OrderItem> orderItems;
}
