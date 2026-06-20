package com.saniya.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {

    //define fields

    @Id  //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    @Column(name="id")
    private int id;

    @Column(name = "first_name") // database will contain first_name column
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    //define constructor

    public Employee(){}

    public Employee( String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //setters and getters

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    //toString method

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
