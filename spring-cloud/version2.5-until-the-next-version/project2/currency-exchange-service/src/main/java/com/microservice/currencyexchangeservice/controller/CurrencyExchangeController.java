package com.microservice.currencyexchangeservice.controller;

import com.microservice.currencyexchangeservice.model.CurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

            // "http://localhost:8000/currency-exchange/from/USD/to/INR" //8001
    @GetMapping("/currency-exchange/{from}/USD/{to}/INR")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from,
                                                  @PathVariable String to){
        CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port); // "8080"
        return currencyExchange;
    
    }

}
