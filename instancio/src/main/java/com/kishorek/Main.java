package com.kishorek;


import com.kishorek.models.Student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("John");
        System.out.println(student);

    }
}