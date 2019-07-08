package com.example.start.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class City {
@Id
    private Long cityId;
    private String city;
    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;

}

