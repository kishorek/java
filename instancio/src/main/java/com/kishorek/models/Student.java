package com.kishorek.models;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Student {
    private String name;
    private String id;
    private char section;
    private double cgpa;
    private String house;
    private Date dateOfJoining;
}
