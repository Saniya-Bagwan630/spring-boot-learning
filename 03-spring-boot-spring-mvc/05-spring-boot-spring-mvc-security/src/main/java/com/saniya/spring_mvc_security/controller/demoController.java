package com.saniya.spring_mvc_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class demoController {

    //mapping for hone page
    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    //mapping for custom login page
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        return "login-page";
    }

    //mapping to leaders page
    @GetMapping("/leaders")
    public String leaders(){
        return "leaders";
    }

    //mapping to systems page
    @GetMapping("/systems")
    public String admins(){
        return "systems";
    }

    //mapping to custom access denied page
    @GetMapping("/access-denied")
    public String access(){
        return "/access-denied";
    }
}
