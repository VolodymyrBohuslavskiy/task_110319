package com.task_110319.task_110319.services;

import com.task_110319.task_110319.DAO.DepartamentDAO;
import com.task_110319.task_110319.models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartamentDAO departamentDAO;

    public void save(Department department) {
        departamentDAO.save(department);
    }

    public List<Department> findAll() {
        return departamentDAO.findAll();
    }

    public Department getOne(int dpID) {
        return departamentDAO.getOne(dpID);
    }

    public void deleteById(int dpID) {
        departamentDAO.deleteById(dpID);
    }
}
