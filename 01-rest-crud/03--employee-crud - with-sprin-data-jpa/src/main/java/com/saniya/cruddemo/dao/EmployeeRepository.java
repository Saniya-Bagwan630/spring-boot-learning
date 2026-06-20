package com.saniya.cruddemo.dao;

import com.saniya.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//extend to jpa repository and provide class and PK
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //no need to write any code
}
