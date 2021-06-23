package com.dependencyinjection.services;

import org.springframework.stereotype.Service;

@Service
public class SocialSecurityServiceDI {

	
	// Component
	public double discount(double grossSalary) {
		return grossSalary * 0.1;
	}
	
}
