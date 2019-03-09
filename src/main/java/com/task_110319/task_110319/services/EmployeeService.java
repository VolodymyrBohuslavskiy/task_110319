package com.task_110319.task_110319.services;

import com.task_110319.task_110319.DAO.EmployeeDAO;
import com.task_110319.task_110319.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDAO employeeDAO;

    public void save(Employee employee) {
        employeeDAO.save(employee);
    }
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    public Employee getOne(int empID) {
        return employeeDAO.getOne(empID);
    }

    public void deleteById(int empID) {
        employeeDAO.deleteById(empID);
    }
}
