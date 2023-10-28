package com.imaginnovate.employees.taxcalculation;

public class TaxSlab5 implements TaxSlab {

	private static Integer TAX_PERCENTAGE = 5;
	
	private static Double TAX_LIMIT = 250000.0;

	@Override
	public Double calculateTax(Double salary) {
		
		Double salaryToTaxCalculated = 0.0;
		if (salary > TAX_LIMIT) {
			salaryToTaxCalculated = TAX_LIMIT;
		} else {
			salaryToTaxCalculated = salary;
		}
		return (salaryToTaxCalculated*TAX_PERCENTAGE)/100;
	}
}
