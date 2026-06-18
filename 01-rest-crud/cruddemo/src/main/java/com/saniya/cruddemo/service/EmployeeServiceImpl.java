package com.saniya.cruddemo.service;

import com.saniya.cruddemo.dao.EmployeeDAO;
import com.saniya.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{

    //dao field
    private EmployeeDAO employeeDAO ;

    //constructor injection
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO=employeeDAO;
    }
    //override all methods
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
