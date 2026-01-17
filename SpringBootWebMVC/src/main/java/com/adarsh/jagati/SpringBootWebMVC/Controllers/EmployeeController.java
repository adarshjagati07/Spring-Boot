package com.adarsh.jagati.SpringBootWebMVC.Controllers;

import com.adarsh.jagati.SpringBootWebMVC.DTO.EmployeeDTO;
import com.adarsh.jagati.SpringBootWebMVC.Exceptions.ResourceNotFoundException;
import com.adarsh.jagati.SpringBootWebMVC.Services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        List<EmployeeDTO> employees =  employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long id){
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElseThrow(()-> new ResourceNotFoundException("Employee was Not Found"));
    }


    @PostMapping(path = "/create")
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO newEmployee){
        EmployeeDTO savedEmployee =  employeeService.createNewEmployee(newEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED); //because employee was created!
    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable(name = "employeeId") Long id, @RequestBody EmployeeDTO employeeDTO){
        return ResponseEntity.ok(employeeService.updateEmployee(id, employeeDTO));
    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(name = "employeeId") Long id){
        String emp =  employeeService.deleteEmployee(id);
        return ResponseEntity.ok(emp);
    }

    @PatchMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeePartially(@PathVariable(name = "employeeId") Long id, @RequestBody Map<String, Object>updates){
        EmployeeDTO emp =  employeeService.updateEmployeePartially(id, updates);
        if(emp == null){
            throw new ResourceNotFoundException("Employee not found!");
        }
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

}
