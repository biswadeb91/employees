package com.imaginnovate.employees.taxcalculation;

import java.util.Calendar;
import java.util.Date;

import com.imaginnovate.employees.exception.WrongDateOfJoining;
import com.imaginnovate.employees.model.Employee;

public class EmployeeTaxCalculator {//Assuming tax calculation for running year

	public Double calculateTax(Employee emp) throws WrongDateOfJoining {
		
		Double salary = emp.getSalary();
		
		Date doj = emp.getDoj();
		
		Double taxableSlary = calculateTaxableSalary(salary, doj);
		
		TaxCalculationEngine taxEngine = new TaxCalculationEngine();
		return taxEngine.calculate(taxableSlary);
	}

		
	private Double calculateTaxableSalary(Double salary, Date doj) throws WrongDateOfJoining {

		if(Calendar.getInstance().getTime().before(doj)) {
			throw new WrongDateOfJoining("Wrong Date of joining. Contact administrator to update.");
		}
		Double taxableSlary = 0.0;
		Date currentdate = new Date();

		Calendar startCal = Calendar.getInstance();
		startCal.set(Calendar.DATE, 1);
		Calendar endCal = Calendar.getInstance();

		//Looping for Jan to Mar this year
		for(int month = 0; month<12; month++) {
			startCal.set(Calendar.MONTH, month);
			endCal.set(Calendar.MONTH, month);
			endCal.set(Calendar.DATE, endCal.getActualMaximum(Calendar.DAY_OF_MONTH));


			if (doj.before(startCal.getTime())) {
				taxableSlary = salary;
			} else if (doj.before(endCal.getTime())) {
				taxableSlary = taxableSlary + calculateSalary(doj, startCal, endCal , salary);
			}
		}


		startCal.add(Calendar.YEAR, -1);
		endCal.add(Calendar.YEAR, -1);
		//Looping for April to DEC
		for(int month = 3; month<12; month++) {
			startCal.set(Calendar.MONTH, month);
			endCal.set(Calendar.MONTH, month);
			endCal.set(Calendar.DATE, endCal.getActualMaximum(Calendar.DAY_OF_MONTH));


			if (doj.before(startCal.getTime())) {
				taxableSlary = salary;
			} else if (doj.before(endCal.getTime())) {
				taxableSlary = taxableSlary + calculateSalary(doj,startCal,  endCal , salary);
			}
		}

		return taxableSlary;
}


	private Double calculateSalary(Date doj, Calendar startCal, Calendar endCal, Double salary) {
		 long diff = endCal.getTime().getTime() - doj.getTime();
	     long workeddays = (diff / 1000 / 60 / 60 / 24)+1;
	     
	     int workingDaysInMonth = endCal.getActualMaximum(Calendar.DAY_OF_MONTH);
	     Double perdaySalary = salary/workingDaysInMonth;
	     
	return perdaySalary*workeddays;
}
	
	

}
