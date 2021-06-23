package com.dependencyinjection.services;

import org.springframework.stereotype.Service;

@Service
public class MGDeductionServiceDI implements DeductionServiceDI {

	@Override
	public double deduction(double amount) {
		return amount * 0.12;
	}

}
