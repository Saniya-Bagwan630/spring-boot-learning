package com.saniya.springboot.formValidation.controller;

import com.saniya.springboot.formValidation.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    //to handle white spaces
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

    }

    @GetMapping("/getForm")
    public String getForm(Model theModel){
        theModel.addAttribute("customer",new Customer());
        return "getForm";
    }

    @PostMapping("/process-form")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,
                              BindingResult theBindingResult){

        System.out.println("customer name: "+theCustomer.getfName()+" "+theCustomer.getlName()+" Free passes: "+theCustomer.getPasses()+" Course code: "+theCustomer.getCourseCode());
        System.out.println(theBindingResult.toString());

        //imp for debugging
        if(theBindingResult.hasErrors()){
            return "getForm";
        }else {
            return "customer-confirmation";
        }
    }


}
