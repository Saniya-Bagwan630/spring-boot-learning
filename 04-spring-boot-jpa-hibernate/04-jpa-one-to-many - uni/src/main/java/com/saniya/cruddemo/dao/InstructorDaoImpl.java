package com.saniya.cruddemo.dao;

import com.saniya.cruddemo.entity.Course;
import com.saniya.cruddemo.entity.Instructor;
import com.saniya.cruddemo.entity.InstructorDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class InstructorDaoImpl implements InstructorDaoInterface{

    EntityManager entityManager;

    @Autowired
    public InstructorDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(int id) {
        Instructor instructor = entityManager.find(Instructor.class,id);
        return instructor;
    }

    @Override
    public InstructorDetails findInstructorDetailById(int id) {
        InstructorDetails instructorDetails = entityManager.find(InstructorDetails.class,id);
        return instructorDetails;
    }

    @Transactional
    @Override
    public void deleteInstructorDetailById(int id) {
        InstructorDetails instructorDetails = entityManager.find(InstructorDetails.class,id);
        System.out.println("Deletin...+ "+instructorDetails);

        if(instructorDetails != null){
            //break link
            instructorDetails.getInstructor().setInstructorDetails(null);
        }
        entityManager.remove(instructorDetails);
    }


    //method imp for lazy loading
    @Override
    public List<Course> findCoursesUsingInstructorId(int id) {

        //create query
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id= : data",Course.class);

        query.setParameter("data",id);

        //execute the query
        List<Course> courses=query.getResultList();
        return courses;
    }

    //using JOIN FETCH
    @Override
    public Instructor findCoursesUsingInstructorIdUsingJOINFETCH(int id) {

        //create query
        TypedQuery<Instructor> query =
                entityManager.createQuery(
                        "SELECT i FROM Instructor i " +
                                "JOIN FETCH i.courses " +
                                "WHERE i.id = :data",
                        Instructor.class);

        query.setParameter("data", id);

        //execute query
        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    @Transactional
    @Override
    public void updateInstructor(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Transactional
    @Override
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class,id);
    }

    @Transactional
    @Override
    public void deleteCourse(int id) {
        Course course=entityManager.find(Course.class,id);
        entityManager.remove(course);
    }

    @Transactional
    @Override
    public void deleteInstructor(int id) {
        //finding instructor
        Instructor instructor = entityManager.find(Instructor.class,id);

        //retrive courses
        List<Course> courses = findCoursesUsingInstructorId(id);

        //set instructor to null
        for (Course c : courses){
            c.setInstructor(null);
        }

        entityManager.remove(instructor);
    }
}
