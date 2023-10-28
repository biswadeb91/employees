package com.imaginnovate.employees.taxcalculation;

public class TaxSlab10 implements TaxSlab {
	
	private static Integer TAX_PERCENTAGE = 10;

	private static Double TAX_LIMIT = 500000.0;
	
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
