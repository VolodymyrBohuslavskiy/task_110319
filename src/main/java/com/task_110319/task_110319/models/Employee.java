package com.task_110319.task_110319.models;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int empID;
    String empName;
    boolean empActive;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Department department;

    public Employee() {
    }

    public Employee(String empName, boolean empActive, Department department) {
        this.empName = empName;
        this.empActive = empActive;
        this.department = department;
    }
}
