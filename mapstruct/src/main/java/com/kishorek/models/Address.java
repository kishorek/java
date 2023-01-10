package com.kishorek.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Address {
    private String addrLine1;
    private String addrLine2;
    private String city;

}
