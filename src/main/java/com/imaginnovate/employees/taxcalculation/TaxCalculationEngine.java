package com.imaginnovate.employees.taxcalculation;

public class TaxCalculationEngine {

	
	protected Double calculate(Double salary){
		Double tax = 0.0;
		Double remainingSalary = salary;
		if( remainingSalary > 0) {
			new TaxSlab0().calculateTax(remainingSalary);
			remainingSalary = remainingSalary - TaxSlab0.TAX_LIMIT;
		} else if(remainingSalary > 0) {
			new TaxSlab5().calculateTax(remainingSalary);
			remainingSalary = remainingSalary - TaxSlab0.TAX_LIMIT;
		} else if(remainingSalary > 0) {
			new TaxSlab10().calculateTax(remainingSalary);
			remainingSalary = remainingSalary - TaxSlab0.TAX_LIMIT;
		} else if(remainingSalary > 0) {
			new TaxSlab20().calculateTax(remainingSalary);
			new CessTaxSlab().calculateTax(salary);
		}
		return tax;
	}
}
