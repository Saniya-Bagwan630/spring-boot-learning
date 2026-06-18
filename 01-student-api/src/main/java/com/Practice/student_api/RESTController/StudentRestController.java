package com.Practice.student_api.RESTController;

import com.Practice.student_api.Entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    //List of students
    private List<Student> students = new ArrayList<>();

    //using @PostConstruct to load the data
    @PostConstruct
    //loadData will run immediately after constructor
    public void loadData(){
        students.add(new Student("Saniya" , "Bagwan"));
        students.add(new Student("Arbaaj" , "Bagwan"));
        students.add(new Student("Payal" , "Lokhande"));
        students.add(new Student("Tanuja" , "Jadhav"));
    }

    //endpoint to get all students
    @GetMapping("/students")
    public List<Student> getAll(){
        return students;
    }

    //returning a student having student_id as index in students list
    @GetMapping("/students/{student_id}")
    // we need to use @@PathVariable to access the data from request
    public Student getById(@PathVariable int student_id){

        //checking student id against list size : exception handling
        if(student_id >= students.size() || student_id<0){
            //throw exception
            throw  new StudentNotFoundException("Student with ID :"+student_id+" is Not Present!");
        }

        return students.get(student_id);
    }

    //exception handlers are placed in global exception handler
}
