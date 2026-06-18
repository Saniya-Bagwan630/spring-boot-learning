package com.saniya.cruddemo.dao;

import com.saniya.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
