package com.imaginnovative.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imaginnovative.employees.model.Employee;

@Repository
public interface EmployeeRepositiry extends JpaRepository<Employee, Long>{

}
