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

    @Override
    public Employee findById(int id) {
        //find employee
        Employee employee = entityManager.find(Employee.class,id);
        //return employee with required id
        return employee;
    }

    @Override
    public Employee save(Employee employee) {

        Employee newEmployee = entityManager.merge(employee); //merge will create the employee if id does not exists else it will update the employee
        return newEmployee;
    }

    @Override
    public void deleteById(int id) {
        //find the employee
        Employee employee = entityManager.find(Employee.class,id);
        //delete the employee
        entityManager.remove(employee);
    }
}
