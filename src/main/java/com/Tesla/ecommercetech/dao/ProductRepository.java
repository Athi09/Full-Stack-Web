package com.Tesla.ecommercetech.dao;

import com.Tesla.ecommercetech.enity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("https://localhost:4200") //({"http://localhost:4200", "http://localhost:49541"})
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);
    //SELECT * FROM products WHERE CategoryId = ?
    //http://localhost:8080/api/products/search/findByCategoryId?id=1

    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
    //SELECT * FROM Products p WHERE p.name LIKE CONCAT('%', :name , '%')


    Page<Product> resourceId(@RequestParam("id") Long id, Pageable pageable);
}
