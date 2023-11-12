package com.example.SpringBoot.repository;


import com.example.SpringBoot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
