package com.dependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dependencyinjection.services.MGDeductionServiceDI;
import com.dependencyinjection.services.PayServiceDI;
import com.dependencyinjection.services.SPDeductionServiceDI;

@SpringBootApplication
public class Ex01Application implements CommandLineRunner{

	@Autowired
	private MGDeductionServiceDI mg;
	
	//@Autowired
	//private SPDeductionServiceDI sp;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(Ex01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		MGDeductionServiceDI mg = new MGDeductionServiceDI();
		SPDeductionServiceDI sp = new SPDeductionServiceDI();
		*/
		
		PayServiceDI payService = new PayServiceDI(mg);
		
		double tax = payService.tax(1000.0);
		System.out.println(tax);
		
	}

}
