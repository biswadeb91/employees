package com.imaginnovate.employees.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.imaginnovate.employees.exception.EmployeeNotFound;
import com.imaginnovate.employees.model.Employee;
import com.imaginnovate.employees.repository.EmployeeRepositiry;
import com.imaginnovate.employees.taxcalculation.EmployeeTaxCalculator;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepositiry repository;
	
	@AutoWired
	EmployeeTaxCalculator taxCalculator;
	
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

	@Override
	public void calculateEmpTaxById(Long id) {
		Optional<Employee> emp = repository.findById(id);
		if(emp.isPresent()) {
			 taxCalculator.calculateTax(emp.get());
		}  else {
			throw new EmployeeNotFound(id);
		}
	}

}
