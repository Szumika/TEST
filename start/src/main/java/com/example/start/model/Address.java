package com.example.start.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Address {
@Id
    private Long addressId;
    private String address;
    private String address2;
    private String district;
    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;
    private String postalCode;
    private String phone;



}
