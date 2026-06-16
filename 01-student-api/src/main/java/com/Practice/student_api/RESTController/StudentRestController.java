package com.Practice.student_api.RESTController;

import com.Practice.student_api.Entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return students.get(student_id);
    }
}
