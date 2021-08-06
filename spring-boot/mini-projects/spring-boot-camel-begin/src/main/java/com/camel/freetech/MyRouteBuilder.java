package com.camel.freetech;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRouteBuilder extends RouteBuilder{
	
	@Override
	public void configure() throws Exception {
		restConfiguration()
        	.component("servlet");

		rest()
        	.path("/test")
        	
        	.get()
            .route()
            .transform(simple("I'm your resource " +
                        "for all the sports!"))
        .endRest()
        
        .post("/")
        .route()
        .to("log:mylogger?showAll=true")
        .transform(simple("Thanks, sport!"))
        .endRest();
		
	}
}