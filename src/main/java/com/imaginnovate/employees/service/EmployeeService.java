package com.imaginnovate.employees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovative.employees.model.Employee;
import com.imaginnovative.employees.repository.EmployeeRepositiry;

@Service
public interface EmployeeService {
	
	List<Employee> findAll();
	
	Employee findById(Long id);
	
	Employee create(Employee emp);
	
	Employee update(Employee emp, Long id);

	void deleteById(Long id);
	}

}
