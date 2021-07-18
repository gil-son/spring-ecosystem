package com.javatechie.spring.camel.api;

import org.apache.camel.Exchange;
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
		// moveAllFiles();
		// moveSpecificFile("myFile");
		moveSpecificFileWithBody("Content 1");
		System.out.println("End...");
	}
	
	public void moveAllFiles() throws Exception{
		from("file:C:/Users/gilso/Desktop/b")
		.to("file:C:/Users/gilso/Desktop/a");
	}

	public void moveSpecificFile(String type) throws Exception{
		from("file:C:/Users/gilso/Desktop/a").filter(header(Exchange.FILE_NAME).startsWith(type))
		.to("file:C:/Users/gilso/Desktop/b");
	}
	
	public void moveSpecificFileWithBody(String content) throws Exception{
		from("file:C:/Users/gilso/Desktop/a").filter(body().contains(content))
		.to("file:C:/Users/gilso/Desktop/b");
	}
}
