package com.Tesla.ecommercetech.enity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="address")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="street")
    private String street;

    @Column(name="city")
    private String city;

    @Column(name="province")
    private String province;

    @Column(name="country")
    private String country;

    @Column(name="zip_Code")
    private String zipCode;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Order order;

}
