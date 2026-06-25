package com.saniya.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
    //create controller method to show form

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloWorld-form";
    }

    //create controller method to process the form and show details

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloWorld-process";
    }

    //controller method to read form data
    //add data to model

    @RequestMapping("/processFormV2")
    public String letsShout(HttpServletRequest request, Model themodel){

        //read request parameter from html form
        String studentName = request.getParameter("studentName");

        //convert name to uppercase
        studentName = studentName.toUpperCase();

        //create a message
        String message = "YO !!!!"+studentName;

        //add message to model
        themodel.addAttribute("message",message);

        return "helloWorld-processV2";
    }
}
