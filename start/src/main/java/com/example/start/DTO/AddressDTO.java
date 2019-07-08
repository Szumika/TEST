package com.example.start.DTO;


import com.example.start.model.Address;
import com.example.start.model.City;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class AddressDTO {

    private String address;
    private String district;
    private City city;
    private String postalCode;
    private String phone;

    public AddressDTO(Address address) {
        this.address = address.getAddress();
        this.postalCode = address.getPostalCode();
        this.phone = address.getPhone();
        this.city = address.getCity();
    }
}
