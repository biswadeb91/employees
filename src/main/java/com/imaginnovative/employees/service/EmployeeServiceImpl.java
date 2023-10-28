package com.imaginnovative.employees.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.imaginnovate.employee.exception.EmployeeNotFound;
import com.imaginnovative.employees.model.Employee;
import com.imaginnovative.employees.repository.EmployeeRepositiry;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepositiry repository;
	
	@Override
	public List<Employee> findAll() {
		return repository.findAll();
	}

	@Override
	public Employee findById(Long id) {
		Optional<Employee> emp = repository.findById(id);
		if(emp.isPresent()) {
			return emp.get();
		}  else {
			throw new EmployeeNotFound(id);
		}
	}

	@Override
	public Employee create(Employee emp) {
		return repository.save(emp);
	}

	@Override
	public Employee update(Employee emp, Long id) {
		Optional<Employee> emp_old = repository.findById(id);

		if(emp_old.isPresent()) {
			emp.setId(id);
			return repository.save(emp);
		} else {
			throw new EmployeeNotFound(id);
		}
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
