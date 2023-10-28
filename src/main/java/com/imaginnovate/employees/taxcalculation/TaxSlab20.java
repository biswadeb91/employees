package com.imaginnovate.employees.taxcalculation;

public class TaxSlab20 implements TaxSlab {

	private static Integer TAX_PERCENTAGE = 20;

	@Override
	public Double calculateTax(Double salary) {
		return (salary*TAX_PERCENTAGE)/100;
	}
}
