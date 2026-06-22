package com.saniya.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//do not forget annotation
@Controller
public class demoController {
    //create mapping for /hello

    @GetMapping("/hello")
    //take model in parameter
    public String sayHello(Model theModel){

        //set attribut to the model
        theModel.addAttribute("theDate",java.time.LocalDateTime.now());

        //return
        return "helloworld";
    }
}
