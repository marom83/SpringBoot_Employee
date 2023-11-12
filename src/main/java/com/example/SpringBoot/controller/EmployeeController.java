package com.example.SpringBoot.controller;

import com.example.SpringBoot.dto.EmployeeDto;
import com.example.SpringBoot.service.EmployeeServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/")
public class  EmployeeController {

    private EmployeeServices employeeServices;
    @RequestMapping(path = "/api/employees", method = RequestMethod.POST)
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee= employeeServices.createEmployee((employeeDto));
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/api/employees/{id}", method = RequestMethod.GET)
    public ResponseEntity<EmployeeDto> getEmployeeId(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto= employeeServices.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    @RequestMapping(path = "/api/employees", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeDto>> getEmployees(){
        List<EmployeeDto> employees = employeeServices.getAllEmployees();
        return  ResponseEntity.ok(employees);
    }
    @RequestMapping(path = "/api/employees/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto = employeeServices.updateEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    @RequestMapping(path = "/api/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeServices.deleteEmployee(employeeId);
        return ResponseEntity.ok("Emploee deleted successfully!");
    }
}
