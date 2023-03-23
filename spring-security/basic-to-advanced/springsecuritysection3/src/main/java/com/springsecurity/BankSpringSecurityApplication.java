package com.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class BankSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankSpringSecurityApplication.class, args);
	}

}
