package com.adarsh.jagati.SpringBootWebMVC.Controllers;

import com.adarsh.jagati.SpringBootWebMVC.DTO.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @GetMapping(path = "/")
    public String home(){
        return "Hello from Adarsh! This is my very first spring REST API.";
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId){
        return new EmployeeDTO(employeeId, "Adarsh", "adarsh@gmail.com",23, LocalDate.of(2025,11,23),true);
    }

    @GetMapping
    public String getAllEmployees(@RequestParam(required = false) Integer age,@RequestParam(required = false) String sortby){
        return "Hii employees of age: "+age+" Sort by: "+sortby;
    }

    @PostMapping(path = "/create")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO inputEmployee){
        inputEmployee.setId(13433L);
        return inputEmployee;
    }
}
