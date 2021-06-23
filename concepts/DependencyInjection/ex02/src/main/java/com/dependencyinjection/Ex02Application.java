package com.dependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dependencyinjection.services.SalaryServiceDI;
import com.dependencyinjection.services.SocialSecurityServiceDI;

@SpringBootApplication
public class Ex02Application implements CommandLineRunner{
	
	@Autowired
	SocialSecurityServiceDI socialSecurityService;

	public static void main(String[] args) {
		SpringApplication.run(Ex02Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// SocialSecurityServiceDI socialSecurityService = new SocialSecurityServiceDI();
		
		SalaryServiceDI salaryService = new SalaryServiceDI(socialSecurityService);
		System.out.println(salaryService.netSalary(4000.0));
	}

}
