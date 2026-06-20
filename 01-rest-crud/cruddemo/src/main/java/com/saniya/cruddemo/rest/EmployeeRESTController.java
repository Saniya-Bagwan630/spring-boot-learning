package com.saniya.cruddemo.rest;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.saniya.cruddemo.dao.EmployeeDAO;
import com.saniya.cruddemo.entity.Employee;
import com.saniya.cruddemo.service.EmployeeService;
import com.saniya.cruddemo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {

    private EmployeeService employeeService;
    //for patch
    private ObjectMapper objectMapper;

    //inject employee dao
    @Autowired
    public EmployeeRESTController(EmployeeService employeeService, ObjectMapper objectMapper){

        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    //getmapping for /employee to get list of all employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    //getmapping for /employee/{id} to get an employee with specific id
    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if(employee == null) {
            throw new RuntimeException("Employee ID Not Found!! -"+id);
        }
        return  employee;
    }

    //postmapping to add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        //we are setting id to 0 to force the insert
        employee.setId(0);
        return employeeService.save(employee);
    }

    //update employee
    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee){
        //check if id is provided
        if(employee.getId()==0){
            throw new RuntimeException("Cannot Update Without ID");
        }
        //if the employee with required id is not present
        else if(employeeService.findById(employee.getId())==null){
            throw new RuntimeException("Id Not Present");
        }
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable int id){
        employeeService.deleteById(id);
    }

    @PatchMapping("/employees/{id}")
    public Employee patchEmployee(@PathVariable int id, @RequestBody Map<String,Object> patchPayload) throws JsonMappingException {
        //extract employee with required id
        Employee tempEmp = employeeService.findById(id);

        //check if employee is present
        if(tempEmp == null){
            throw new RuntimeException("Employee not Found ID- "+id);
        }

        //request body must not contain id to maintain db consistency
        if(patchPayload.containsKey("id")){
            throw new RuntimeException("Request Body Cannot Contain ID");
        }

        //update employee
        Employee patchedEmp = objectMapper.updateValue(tempEmp , patchPayload);

        //save and return
        return employeeService.save(patchedEmp);
    }

}
