package com.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
//@ComponentScan("com.springsecurity.controller")
@ComponentScans({ @ComponentScan("com.springsecurity.controller"), @ComponentScan("com.springsecurity.config")})
public class BankSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankSpringSecurityApplication.class, args);
	}

}
