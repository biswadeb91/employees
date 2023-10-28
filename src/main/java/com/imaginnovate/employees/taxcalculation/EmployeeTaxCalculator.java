package com.imaginnovate.employees.taxcalculation;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.hibernate.internal.util.compare.CalendarComparator;

import com.imaginnovate.employees.model.Employee;

public class EmployeeTaxCalculator {//Assuming tax calculation for running year

	public Double calculateTax(Employee emp) {
		
		Double salary = emp.getSalary();
		
		Double taxableSlary = 0.0;
		
		Date doj = emp.getDoj();
		
		Date currentdate = new Date();
		
		Calendar cal = Calendar.getInstance();
		
		if(currentdate.after(doj)) {
			cal.set(1, 2, Calendar.YEAR);
			if (doj.before(cal.getTime())) {
				taxableSlary = salary;
			} else if (doj.before(cal.add(Calendar.DAY_OF_MONTH, 30).getTime())) {
				taxableSlary = salary;
			}
		}
		return null;
		
		
	}
	
	

}
