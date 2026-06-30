package com.saniya.cruddemo.dao;

import com.saniya.cruddemo.entity.Course;
import com.saniya.cruddemo.entity.Instructor;
import com.saniya.cruddemo.entity.InstructorDetails;

import java.util.List;

public interface InstructorDaoInterface {

    public void save(Instructor instructor);
    public Instructor findById(int id);
    public void deleteInstructor(int id);
    public InstructorDetails findInstructorDetailById(int id);
    public void deleteInstructorDetailById(int id);

    //for lazy loading of courses
    public List<Course> findCoursesUsingInstructorId(int id);
}
