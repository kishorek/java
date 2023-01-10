package com.kishorek.models;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class AddressResponse {
    private String addrLine1;
    private String addrLine2;
    private String city;

    private Date updatedDate;

}
