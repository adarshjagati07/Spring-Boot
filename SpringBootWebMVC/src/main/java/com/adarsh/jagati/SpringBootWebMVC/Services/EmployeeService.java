package com.adarsh.jagati.SpringBootWebMVC.Services;

import com.adarsh.jagati.SpringBootWebMVC.DTO.EmployeeDTO;
import com.adarsh.jagati.SpringBootWebMVC.Entities.EmployeeEntity;
import com.adarsh.jagati.SpringBootWebMVC.Repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        List<EmployeeDTO> employeesDTO = new ArrayList<>();
        for(var employee: employees){
            employeesDTO.add(modelMapper.map(employee, EmployeeDTO.class));
        }
        return employeesDTO;
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        Optional<EmployeeEntity> employeeEntity =  employeeRepository.findById(id);
        return employeeEntity.map(employeeEntity1 -> modelMapper.map(employeeEntity1, EmployeeDTO.class));
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO newEmployee) {
        EmployeeEntity employeeEntity = employeeRepository.save(modelMapper.map(newEmployee, EmployeeEntity.class));
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        if(employeeRepository.findById(id).orElse(null) == null || employeeDTO == null) return null;
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeEntity.setId(id);
        //this does the work of updation for us, look for the id and saves this data.
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public String deleteEmployee(Long id) {
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            return "Employee Deleted with Id: "+id;
        }else {
            return "Employee with id: "+id+" not found";
        }
    }

    public EmployeeDTO updateEmployeePartially(Long id, Map<String, Object>updates) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        if(employeeEntity == null) return null;

        updates.forEach((key, value) -> {
            Field fieldTobeUpdated = ReflectionUtils.findRequiredField(EmployeeEntity.class, key);
            fieldTobeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldTobeUpdated, employeeEntity, value);
        });

        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}
