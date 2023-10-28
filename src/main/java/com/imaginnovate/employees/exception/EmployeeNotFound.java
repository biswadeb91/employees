package com.imaginnovate.employees.exception;

public class EmployeeNotFound extends RuntimeException {

	public EmployeeNotFound(Long id) {
		super("Employee details not found for id : " + id);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

}
