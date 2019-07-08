package com.example.start.DTO;


import com.example.start.model.City;
import com.example.start.model.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Setter
@Getter
public class CityDTO {

    private String city;
    private Country country;

    public CityDTO(City city) {
        this.city = city.getCity();
        this.country = city.getCountry();

    }
}

