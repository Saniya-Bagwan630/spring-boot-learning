package com.saniya.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
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
}
