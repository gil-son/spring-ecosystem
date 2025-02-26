package com.microservice.currencyexchangeservice.controller;

import com.microservice.currencyexchangeservice.model.CurrencyExchange;
import com.microservice.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeRepository repository;

    @Autowired
    private Environment environment;

    // That microservice work with the project1 https://github.com/gil-son/spring-ecosystem/tree/main/spring-cloud/version2.5-until-the-next-version/project1/spring-cloud-config-server

            // "http://localhost:8000/currency-exchange/from/USD/to/INR" //8001
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from,
                                                  @PathVariable String to){
//      CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);

        if(currencyExchange == null){
            throw new RuntimeException("Unable to Find data for "+from+" to "+to);
        }

        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port); // "8080"

        return currencyExchange;
    
    }

}
