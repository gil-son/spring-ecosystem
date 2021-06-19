package com.price.controller;



import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.price.model.Price;

@RestController
@RequestMapping("/prices")
public class PriceController {
	
	@GetMapping
	public String test() {
		return "Price";
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<Price> isPrice(@PathVariable Long code){
		
		Price p1 = new Price(code, new BigDecimal("100"));
		
		return ResponseEntity.ok(p1);
	}
	
	
}
