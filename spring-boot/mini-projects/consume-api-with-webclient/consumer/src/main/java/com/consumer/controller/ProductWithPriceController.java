package com.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consumer.model.ProductWithPrice;
import com.consumer.service.ProductWithPriceService;

@RestController
//@RequestMapping("/consumers")
public class ProductWithPriceController {
	
	/*
		@GetMapping
		public String test() {
			return "Consumer";
		}
	*/
	@Autowired
	private ProductWithPriceService productWithPriceService;
	
	@GetMapping("/product/{code}/price")
	public ResponseEntity<ProductWithPrice> isProductWithPrice(@PathVariable Long code){
		
			ProductWithPrice productWithPrice = this.productWithPriceService.webClientProductWithPriceService(code);
			
			return ResponseEntity.ok(productWithPrice);
	}
	
}
