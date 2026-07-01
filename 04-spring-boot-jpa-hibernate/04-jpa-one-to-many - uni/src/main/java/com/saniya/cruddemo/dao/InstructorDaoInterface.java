package com.saniya.cruddemo.dao;

import com.saniya.cruddemo.entity.Course;
import com.saniya.cruddemo.entity.Instructor;
import com.saniya.cruddemo.entity.InstructorDetails;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface InstructorDaoInterface {

    public void save(Instructor instructor);
    public Instructor findById(int id);
    public void deleteInstructor(int id);
    public InstructorDetails findInstructorDetailById(int id);
    public void deleteInstructorDetailById(int id);

    //for lazy loading of courses
    public List<Course> findCoursesUsingInstructorId(int id);

    //using JOIN FETCH
    public Instructor findCoursesUsingInstructorIdUsingJOINFETCH(int id);

    public void updateInstructor(Instructor instructor);
    public void updateCourse(Course course);

    Course findCourseById(int id);

    public void deleteCourse(int id);

    public void save(Course course);

    public Course findCourseAndReviewsByCourseId(int id);

}
