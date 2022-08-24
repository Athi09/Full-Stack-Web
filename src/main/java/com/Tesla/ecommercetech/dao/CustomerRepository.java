package com.Tesla.ecommercetech.dao;

import com.Tesla.ecommercetech.enity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
