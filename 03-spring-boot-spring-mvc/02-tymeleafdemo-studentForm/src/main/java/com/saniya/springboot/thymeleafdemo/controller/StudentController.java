package com.saniya.springboot.thymeleafdemo.controller;

import com.saniya.springboot.thymeleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @GetMapping("/getForm")
    public String showForm(Model theModel){

        //create new student object
        Student student = new Student();

        //add student object as model attribute
        theModel.addAttribute("student",student);
        return "student-form";
    }

    @PostMapping("/process-student-form")
    public String processForm(@ModelAttribute("student") Student student){

        //log data
        System.out.println("The Student: "+student.getfName()+" "+student.getlName()+" Country: "+student.getCountry());

        return "getInfo";
    }
}
