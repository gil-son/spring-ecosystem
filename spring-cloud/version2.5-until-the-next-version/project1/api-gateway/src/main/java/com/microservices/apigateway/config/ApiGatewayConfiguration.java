package com.microservices.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        //  Function<PredicateSpec, Buildable<Route>> routeFunction = p -> ...
        return builder.routes()
                .route(p -> p.path("/get")
                .filters(f -> f
                        .addRequestHeader("MyHeader", "MyURI")
                        .addRequestParameter("Param", "MyValue"))

                    .uri("http://httpbin.org:80"))
                .route(p -> p.path("/currency-exchange/**")
                        .uri("lb://currency-exchange")) // to use Load Balancing
                .route(p -> p.path("/currency-conversion-rest-template/**")
                        .uri("lb://currency-conversion")) // to use Load Balancing
                .route(p -> p.path("/currency-conversion-feign/**")
                        .uri("lb://currency-conversion")) // to use Load Balancing
                .route(p -> p.path("/currency-conversion-new/**")
                        .filters(f -> f.rewritePath( // replace path of endpoint
                                "/currency-conversion-new/(?<segment>.*)",
                                "/currency-conversion-feign/${segment}"))
                        .uri("lb://currency-conversion")) // to use Load Balancing
                .build();
    }
}
