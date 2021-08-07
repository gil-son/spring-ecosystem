package springbootcamelbombegin;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class MyRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
	restConfiguration()
    	.component("servlet")
    	.bindingMode(RestBindingMode.auto); // received and convert JSON or XML 

	rest()
    	.path("/person")
    	
    	.get()
        .route()
        .transform(simple("I'm your resource " +
                    "for all the person!"))
    .endRest()
    
    .post("/").type(Person.class)
    .route()
    .to("log:mylogger?showAll=true")
    .transform(simple("Thank you to submit a new person! : ${body.name}"))
    .endRest();
    
   
	}

}
