package com.example.SpringBoot.mapper;

import com.example.SpringBoot.dto.EmployeeDto;
import com.example.SpringBoot.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployee(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
