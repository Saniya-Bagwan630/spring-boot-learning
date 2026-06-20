package com.saniya.cruddemo.service;

import com.saniya.cruddemo.dao.EmployeeRepository;
import com.saniya.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    //dao field
    private EmployeeRepository employeeRepository ;

    //constructor injection
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    //override all methods
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {

        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee=null;

        //returns true if employee is present
        if(result.isPresent()){
            employee = result.get();
        }else{
            throw new RuntimeException("Employee Not Found ID- "+id);
        }
        return employee;
    }

    //@Transactional is not required while using jpa repository
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
