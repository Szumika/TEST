package com.example.start.DTO;

import com.example.start.model.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@ToString
@Getter
@Setter
public class CustomerDTO {

private String firstName;
private String lastName;
private String email;
private String address;

    public CustomerDTO(Customer customer) {
       this.firstName = customer.getFirstName();
       this.lastName = customer.getLastName();
       this.email = customer.getEmail();
       this.address = customer.getAddress().getAddress() + " District: " + customer.getAddress().getDistrict()
               + " City: " + customer.getAddress().getCity().getCity()
               + " Country: " + customer.getAddress().getCity().getCountry().getCountry()
               + " PostalCode: " + customer.getAddress().getPostalCode()
               + " PhoneNumber: " + customer.getAddress().getPhone();
    }

}
