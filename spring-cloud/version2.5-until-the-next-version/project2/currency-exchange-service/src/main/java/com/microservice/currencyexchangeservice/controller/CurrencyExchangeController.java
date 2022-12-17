package com.microservice.currencyexchangeservice.controller;

import com.microservice.currencyexchangeservice.model.CurrencyExchange;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

            // "http://localhost:8000/currency-exchange/from/USD/to/INR"
    @GetMapping("/currency-exchange/{from}/USD/{to}/INR")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from,
                                                  @PathVariable String to){
        return new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
    }

}
