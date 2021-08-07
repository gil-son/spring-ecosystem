package springbootcamelbombegin;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
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
   
    // The process will generate the response
    .process(new Processor() {

		@Override
		public void process(Exchange exchange) throws Exception {
			Person person = exchange.getMessage().getBody(Person.class);
			PersonResponse response = new PersonResponse();
			response.setMessage("Thanks to submitting: "+person.getName());
			// Insert record database goes here
			exchange.getMessage().setBody(response);
		}
    	
    })
    
    // .transform(simple("Thank you to submit a new person! : ${body.name}"))
    .endRest();
    
   
	}

}
