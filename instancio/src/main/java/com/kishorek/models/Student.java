package com.kishorek.models;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Student {
    private String name;
    private String id; //ID Format: LSV<ID>
    private char section; //The student can be placed in any sections from 'A' - 'K'
    private double cgpa; //Can be between 0.0 and 4.0
    private String house; // The school has 'White', 'Blue', 'Red', 'Green' sport houses
    private Date dateOfJoining; // Should be a past date
}
