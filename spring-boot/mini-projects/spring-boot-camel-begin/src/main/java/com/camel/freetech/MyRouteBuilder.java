package com.camel.freetech;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder{
	@Override
	public void configure() throws Exception {
		from("file:src/input?noop=true") //  noop=true = copy file and don't cut
			.log("${body}");
		
	}
}