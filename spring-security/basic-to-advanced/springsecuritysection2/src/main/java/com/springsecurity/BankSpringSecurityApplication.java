package com.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.springsecurity.controller")
public class BankSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankSpringSecurityApplication.class, args);
	}

}
