package com.javatechie.spring.camel.api;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCamelApplication extends RouteBuilder{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCamelApplication.class, args);
	}

	@Override
	public void configure() throws Exception {
		// move data from one another file
		
		System.out.println("Started...");
		from("file:C:/Users/gilso/Desktop/a")
		.to("file:C:/Users/gilso/Desktop/b");
		System.out.println("End...");
	}

}
