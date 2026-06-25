package com.saniya.springboot.thymeleafdemo.model;

public class Student {
    private String fName;
    private String lName;
    private String country;
    public Student() {}


    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getCountry() {
        return country;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
