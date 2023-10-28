package com.imaginnovate.employees.taxcalculation;

public class CessTaxSlab implements TaxSlab {

	private static Integer TAX_PERCENTAGE = 2;
	
	private static Double TAX_LIMIT = 2500000.0;

	@Override
	public Double calculateTax(Double salary) {
		Double salaryToTaxCalculated = 0.0;
		if (salary > TAX_LIMIT) {
			salaryToTaxCalculated = salary - TAX_LIMIT;
		}
		return (salaryToTaxCalculated*TAX_PERCENTAGE)/100;
	}
}
