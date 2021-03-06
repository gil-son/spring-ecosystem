package com.registerevent.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.registerevent.controller"}) // Spring Boot version 2.0 and above... required
public class RegistereventApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistereventApplication.class, args);
	}

}
