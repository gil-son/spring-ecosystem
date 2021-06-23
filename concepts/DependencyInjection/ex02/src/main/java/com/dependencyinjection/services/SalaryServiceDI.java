package com.dependencyinjection.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dependencyinjection.services.SalaryServiceDI;

@Service
public class SalaryServiceDI {
	
	// Uncoupled solution - not a good practice
	
		@Autowired
		SocialSecurityServiceDI socialSecurityService;
		
	
	
	public SalaryServiceDI(SocialSecurityServiceDI socialSecurityService) {
		this.socialSecurityService = socialSecurityService;
	}
	
	public double netSalary(double grossSalary) {
		
		double tax = grossSalary * 0.2;
		double socialSecurity = socialSecurityService.discount(grossSalary);
		
		return grossSalary - tax - socialSecurity;
	}
}
