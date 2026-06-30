package com.saniya.cruddemo.dao;

import com.saniya.cruddemo.entity.Instructor;

public interface InstructorDaoInterface {

    public void save(Instructor instructor);
    public Instructor findById(int id);
    public void deleteInstructor(int id);
}
