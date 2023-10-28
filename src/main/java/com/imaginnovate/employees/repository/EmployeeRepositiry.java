package com.imaginnovate.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imaginnovate.employees.model.Employee;

@Repository
public interface EmployeeRepositiry extends JpaRepository<Employee, Long>{

}
