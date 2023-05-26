package com.javalearner.employeeapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javalearner.employeeapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
