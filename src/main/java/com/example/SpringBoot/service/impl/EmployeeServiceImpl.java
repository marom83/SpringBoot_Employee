package com.example.SpringBoot.service.impl;

import com.example.SpringBoot.dto.EmployeeDto;
import com.example.SpringBoot.entity.Employee;
import com.example.SpringBoot.exception.ResourceNotFoundException;
import com.example.SpringBoot.mapper.EmployeeMapper;
import com.example.SpringBoot.repository.EmployeeRepository;
import com.example.SpringBoot.service.EmployeeServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeServices {
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployee(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
         Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id: " + employeeId));
        return EmployeeMapper.mapToEmployee(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees= employeeRepository.findAll();
        return employees.stream().map((employee) ->
                EmployeeMapper.mapToEmployee(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists wirh given id: " + employeeId)
        );

        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());

         Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployee((updatedEmployeeObj));
    }

    @Override
    public void deleteEmployee(Long employeeId) {


        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists wirh given id: " + employeeId)
        );

        employeeRepository.deleteById(employeeId);
    }
}
