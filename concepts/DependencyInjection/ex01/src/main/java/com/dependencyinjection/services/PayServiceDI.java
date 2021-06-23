package com.dependencyinjection.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



public class PayServiceDI {
	
									 
	DeductionServiceDI deductionService;
	
	
	public PayServiceDI(DeductionServiceDI region) {
		deductionService = region;
	}
	
	
	public double tax(double amount) {
		amount = amount - deductionService.deduction(amount);
		return amount * 0.2;
		
	}
	
}
