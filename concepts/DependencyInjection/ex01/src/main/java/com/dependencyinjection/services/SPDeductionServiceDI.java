package com.dependencyinjection.services;

import org.springframework.stereotype.Service;


public class SPDeductionServiceDI implements DeductionServiceDI{
	
	@Override
	public double deduction(double amount) {
		return amount * 0.10;
	}
}
