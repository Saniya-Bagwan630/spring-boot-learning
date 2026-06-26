package com.saniya.springboot.thymeleafdemo.controller;

import com.saniya.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    //this anotation is used to inject the data from applications.properties file
    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${OSs}")
    private List<String> OSs;

    @GetMapping("/getForm")
    public String showForm(Model theModel){

        //create new student object
        Student student = new Student();

        //add student object as model attribute
        theModel.addAttribute("student",student);

        //add list of countries to model
        theModel.addAttribute("countries",countries);

        //add list of languages to model
        theModel.addAttribute("languages" , languages);

        //add list of OSs to model
        theModel.addAttribute("OSs" , OSs);


        return "student-form";
    }

    @PostMapping("/process-student-form")
    public String processForm(@ModelAttribute("student") Student student){

        //log data
        System.out.println("The Student: "+student.getfName()+" "+student.getlName()+" Country: "+student.getCountry()+" Favourite Language: "+student.getFavouriteLang()+" Favourite OS: "+student.getFavouriteOS());

        return "getInfo";
    }
}
