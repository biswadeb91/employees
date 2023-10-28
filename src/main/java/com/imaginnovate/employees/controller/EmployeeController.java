package com.imaginnovate.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnovate.employees.model.Employee;
import com.imaginnovate.employees.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService services;
	
	@GetMapping("/employees")
	public List<Employee> fetch(){
		return services.findAll();
	}
	
	@GetMapping("/employee/{id}")
	public Employee fetchById(@PathVariable Long id) {
		return services.findById(id);
	}
	
	@PostMapping("/employee")
	public Employee create(@RequestBody Employee emp){
		return services.create(emp);
	}
	
	@PutMapping("/employee/{id}")
	public Employee update(@RequestBody Employee emp, @PathVariable Long id) {
		return services.update(emp, id);
	}

	
	@DeleteMapping("/employee/{id}")
	public void delete(@PathVariable Long id) {
		services.deleteById(id);
	}
	
	@GetMapping("/employeetax/{id}")
	public ResponseEntity<Object> calculateEmpTaxById(@PathVariable Long id) {
		services.calculateEmpTaxById(id);
	}
}
