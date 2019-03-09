package com.task_110319.task_110319.DAO;

import com.task_110319.task_110319.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
}
