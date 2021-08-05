package com.camel.freetech;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCamelBeginApplication {

	public static void main(String... args) throws Exception{
		SpringApplication.run(SpringBootCamelBeginApplication.class, args);
		
		Main main = new Main();
		main.addRouteBuilder(new MyRouteBuilder());
		main.run(args);
	}

	
}