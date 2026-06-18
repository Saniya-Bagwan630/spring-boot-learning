package com.saniya.cruddemo.rest;

import com.saniya.cruddemo.dao.EmployeeDAO;
import com.saniya.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {

    private EmployeeDAO employeeDAO;

    //inject employee dao
    @Autowired
    public EmployeeRESTController(EmployeeDAO employeeDAO){
        this.employeeDAO=employeeDAO;
    }

    //getmapping for /employee to get list of all employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }
}
