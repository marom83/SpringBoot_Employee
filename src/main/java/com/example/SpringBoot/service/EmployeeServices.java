package com.example.SpringBoot.service;

import com.example.SpringBoot.dto.EmployeeDto;

import java.util.List;

public interface EmployeeServices {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee);

    void deleteEmployee(Long employeeId);
}
