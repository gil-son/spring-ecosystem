package com.javatechie.spring.camel.api;

import java.util.Arrays;

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
		// moveSpecificFileWithBody("Specific content");
		// fileProcess();
		multiFileProcessor();
		System.out.println("End...");
	}
	
	public void moveAllFiles() throws Exception{
		from("file:C:/Users/gilso/Desktop/b")
		.to("file:C:/Users/gilso/Desktop/a");
	}

	public void moveSpecificFile(String type) throws Exception{
		from("file:C:/Users/gilso/Desktop/a")
		.filter(header(Exchange.FILE_NAME).startsWith(type))
		.to("file:C:/Users/gilso/Desktop/b");
	}
	
	public void moveSpecificFileWithBody(String content) throws Exception{
		from("file:C:/Users/gilso/Desktop/Repositories/gil-son/spring-ecosystem/spring-boot/mini-projects/spring-boot-camel/source")
		// .filter(body().contains(content)) 
		.filter(body().startsWith(content))
		.to("file:C:/Users/gilso/Desktop/Repositories/gil-son/spring-ecosystem/spring-boot/mini-projects/spring-boot-camel/destination");
	}
	
	
	public void fileProcess(){
		from("file:a?noop=true").process( p -> {
			String body = p.getIn().getBody(String.class);
			StringBuilder sb = new StringBuilder();
			Arrays.stream(body.split(" ")).forEach( s -> {
				sb.append( s + ",");
			});
			p.getIn().setBody(sb);
		})
		
		// .to("file:b");
		.to("file:b?fileName=records.csv");
	}
	
	
	public void multiFileProcessor() {
		from("file:a?noop=true").unmarshal().csv().split(body().tokenize(",")).choice()
		.when(body().contains("LastNameA")).to("file:b?fileName=lastnamea.csv")
		.when(body().contains("LastNameB")).to("file:b?fileName=lastnameb.csv")
		.when(body().contains("LastNameC")).to("file:b?fileName=lastnamec.csv");
	}
	
}
