package com.example.start.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Entity
public class Users {
    @Id
    public String email;
    private String passwordhash;
    private String token;
    private Boolean active;
    private Boolean deleted;
}
