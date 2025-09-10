package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor   // generates a no-args constructor
@AllArgsConstructor  // generates a constructor with all fields
@ToString            // generates toString() method
public class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;

}
