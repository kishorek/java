package com.kishorek.models;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class UserResponse {
    private String displayName;

    private String token;

    private boolean showMenu;

    private Date lastLoggedOn;

    private String mainRole;

    private Date updatedDate;

    private Address address;

}
