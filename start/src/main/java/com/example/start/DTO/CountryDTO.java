package com.example.start.DTO;


import com.example.start.model.Country;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class CountryDTO {
    private String country;

    public CountryDTO(Country country) {
        this.country = country.getCountry();
    }
}
