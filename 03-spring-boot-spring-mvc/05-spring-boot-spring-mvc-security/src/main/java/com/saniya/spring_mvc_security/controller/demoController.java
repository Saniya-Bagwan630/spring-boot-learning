package com.saniya.spring_mvc_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class demoController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        return "login-page.html";
    }
}
