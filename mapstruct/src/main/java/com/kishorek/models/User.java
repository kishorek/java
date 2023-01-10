package com.kishorek.models;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private Date lastLoggedOn;

    private Date updatedDate;

    private boolean menuVisible;

    private String mainRole;

    private Address address;

    /* Fluent Setter */
    public User setMainRole(String mainRole) {
        this.mainRole = mainRole;
        return this;
    }
}
