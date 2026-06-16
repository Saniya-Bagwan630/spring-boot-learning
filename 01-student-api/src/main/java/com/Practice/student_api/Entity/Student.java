package com.Practice.student_api.Entity;

public class Student {
    private String f_name;
    private String l_name;

    public Student(){}

    //parameterized constructor

    public Student(String f_name, String l_name) {
        this.f_name = f_name;
        this.l_name = l_name;
    }

    //setters
    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    //getters

    public String getF_name() {
        return f_name;
    }

    public String getL_name() {
        return l_name;
    }
}
