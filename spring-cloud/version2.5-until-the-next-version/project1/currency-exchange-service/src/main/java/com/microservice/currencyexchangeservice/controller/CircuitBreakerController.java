package com.microservice.currencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class CircuitBreakerController {

    private Logger logger =
            LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    //@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse") // Will retry attempts in 'n' times (look in application.properties). If not work, then will call hardcodedResponse
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
    // in 10s I want only 2 request to the sample api | 10s => 10000 calls to the sample api
    @RateLimiter(name="default")
    //@Bulkhead(name="sample-api")
    //10s => 10000 calls to the sample api
    public String sampleAPI(){
        logger.info("Sample Api call received");
//        ResponseEntity<String> forEntity =
//                new RestTemplate().getForEntity("http://localhost:8080/some-application", String.class);
//
//        return forEntity.getBody();
        return "sample-api";
    }

    public String hardcodedResponse(Exception ex){
        return "fallback-response";
    }
}
