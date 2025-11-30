package com.adarsh.jagati.SpringBootWebMVC.Controllers;

import com.adarsh.jagati.SpringBootWebMVC.DTO.EmployeeDTO;
import com.adarsh.jagati.SpringBootWebMVC.Entities.EmployeeEntity;
import com.adarsh.jagati.SpringBootWebMVC.Repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepo;

    //constructor dependency injection of employee repo
    // (just for testing purpose here, otherwise all the repo and entity class will go to service layer only)
    public EmployeeController(EmployeeRepository employeeRepo){
        this.employeeRepo = employeeRepo;
    }


    @GetMapping(path = "/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long id){
        return employeeRepo.findById(id).orElse(null);
    }

    @GetMapping(path = "/")
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false) Integer age,@RequestParam(required = false) String sortby){
        return employeeRepo.findAll();
    }

    @PostMapping(path = "/create")
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity newEmployee){
        return employeeRepo.save(newEmployee);
    }
}
