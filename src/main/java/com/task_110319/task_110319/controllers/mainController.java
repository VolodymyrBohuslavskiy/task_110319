package com.task_110319.task_110319.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task_110319.task_110319.models.Department;
import com.task_110319.task_110319.models.Employee;
import com.task_110319.task_110319.services.DepartmentService;
import com.task_110319.task_110319.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@CrossOrigin("*")
@RestController
public class mainController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/add-employee")
    public void add_employee(@RequestBody String employee) throws IOException {
        Employee e = new ObjectMapper().readValue(employee, Employee.class);
        e.setDepartment(null);
        employeeService.save(e);
    }


    @PostMapping("/add-dep")
    public void addDep(@RequestBody String departamtnt) throws IOException {
        departmentService.save(new ObjectMapper().readValue(departamtnt, Department.class));
    }

    @GetMapping("/sowallempl")
    public String sowallempl() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(employeeService.findAll());
    }

    @GetMapping("/sowalldep")
    public String sowalldep() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(departmentService.findAll());
    }

    @DeleteMapping("/delete-empl{empID}")
    public void delete_empl(@PathVariable int empID) {
        employeeService.deleteByEmpID(empID);
    }

    @GetMapping("/findbyname-{name}")
    public String findbyname(@PathVariable String name) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(employeeService.findByEmpNameStartingWith(name));
    }

}
