package com.luv2code.springboot.thymeleafcruddemo.controller;

import com.luv2code.springboot.thymeleafcruddemo.entity.Employee;
import com.luv2code.springboot.thymeleafcruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel){
        //get the employees using employee service

        List<Employee> employees = employeeService.findAll();

        //add it ad attribute to model
        theModel.addAttribute("employees",employees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        //create object of employee
        Employee employee = new Employee();

        //add the employee to model as attribute
        theModel.addAttribute("employee",employee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){

        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel){ //getting id using reqparams

        //find employee
        Employee employee = employeeService.findById(theId);

        //add it to attribute
        theModel.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId,Model theModel){ //getting id using reqparams

        //find employee
        Employee employee = employeeService.findById(theId);

        //delete the employee
        employeeService.deleteById(theId);

        return "redirect:/employees/list";
    }

}
