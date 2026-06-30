package com.saniya.cruddemo.dao;

import com.saniya.cruddemo.entity.Instructor;
import com.saniya.cruddemo.entity.InstructorDetails;

public interface InstructorDaoInterface {

    public void save(Instructor instructor);
    public Instructor findById(int id);
    public void deleteInstructor(int id);
    public InstructorDetails findInstructorDetailById(int id);
}
