package com.conversion.microservices.currencyconversionservice.proxy;

import com.conversion.microservices.currencyconversionservice.entity.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange", url = "localhost:8000") // Name of the project to consume API. In this case is the project2 , the url
@FeignClient(name="currency-exchange") // With Load Balance
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(@PathVariable String from,
                                                    @PathVariable String to);

}
