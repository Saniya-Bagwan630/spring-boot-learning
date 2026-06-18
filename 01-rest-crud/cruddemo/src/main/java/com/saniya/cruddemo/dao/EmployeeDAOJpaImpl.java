package com.saniya.cruddemo.dao;

import com.saniya.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    //define fields for entity manager
    private EntityManager entityManager;

    //set constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    //override the method from interface
    @Override
    public List<Employee> findAll() {
        //create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //execute query
        List<Employee> employees = theQuery.getResultList();

        //return the result
        return employees;
    }
}
