package com.saniya.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    //create controller method to show form
    //requestmapping handles all type of requests like GET, POST etc
    @GetMapping("/showForm")
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

    @GetMapping("/processFormV3")

    //@RequestParam will take the studentName from form and save it in theName
    public String processFormV2(@RequestParam("studentName") String theName, Model themodel){

        //convert name to uppercase
        theName = theName.toUpperCase();

        //create a message
        String message = "Hey My Friend "+theName;

        //add message to model
        themodel.addAttribute("message",message);

        return "helloWorld-processV2";
    }


}
