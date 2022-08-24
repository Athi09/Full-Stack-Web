package com.Tesla.ecommercetech.enity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="product_category")
//@Data -- known bug
@Getter  //to generate Getters and Setters for the class
@Setter

public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    //One Category consist of Many Category / One Category mapped to Many Products
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Product> products; //Shows that category is mapped to many Products or category receives many products so its like we creating an Array


}
