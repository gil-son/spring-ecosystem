package com.dependencyinjection.services;

import org.springframework.stereotype.Service;

@Service
public interface DeductionServiceDI {
	public double deduction(double amount);
}
