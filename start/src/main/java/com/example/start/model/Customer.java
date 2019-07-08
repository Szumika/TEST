package com.example.start.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Customer {
    @Id
private Long customerId;
private String firstName;
private String lastName;
@Email
private String email;
@NotNull
@Column(columnDefinition = "boolean default true")
private Boolean activebool;
@ManyToOne
@JoinColumn(name="address_id")
    private Address address;


}
