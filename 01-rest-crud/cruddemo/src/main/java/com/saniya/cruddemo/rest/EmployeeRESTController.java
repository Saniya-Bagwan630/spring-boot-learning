package com.saniya.cruddemo.rest;

import com.saniya.cruddemo.dao.EmployeeDAO;
import com.saniya.cruddemo.entity.Employee;
import com.saniya.cruddemo.service.EmployeeService;
import com.saniya.cruddemo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {

    private EmployeeService employeeService;

    //inject employee dao
    @Autowired
    public EmployeeRESTController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    //getmapping for /employee to get list of all employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
}
