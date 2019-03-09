package com.task_110319.task_110319.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task_110319.task_110319.models.Department;
import com.task_110319.task_110319.models.Employee;
import com.task_110319.task_110319.services.DepartmentService;
import com.task_110319.task_110319.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class mainController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/add-employee")
    public void add_employee(Employee employee) {
        employeeService.save(employee);
    }

    @PostMapping("/add-department")
    public void add_department(Department department) {
        departmentService.save(department);
    }

    @PutMapping("/add-empl-to-dep")
    public void addempltodep(@RequestParam int empID, @RequestParam int dpID) {
        Employee employee = employeeService.getOne(empID);
        Department department = departmentService.getOne(dpID);
        employee.setDepartment(department);
        employeeService.save(employee);
    }

    @GetMapping("/sowallempl")
    public String sowallempl() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(employeeService.findAll());
    }


    @GetMapping("/sowalldep")
    public String sowalldep() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(departmentService.findAll());
    }

    @DeleteMapping("/delete-empl")
    public void delete_empl(@RequestParam int empID){
        employeeService.deleteById(empID);
    }

    @DeleteMapping("/delete-dep")
    public void delete_dep(@RequestParam int dpID){
        departmentService.deleteById(dpID);
    }



}
