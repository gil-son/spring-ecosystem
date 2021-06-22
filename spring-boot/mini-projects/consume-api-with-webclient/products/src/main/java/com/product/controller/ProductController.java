package com.product.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

	/*
	@GetMapping
	public String method() {
		return "Test";
	}
	*/
	
	@GetMapping("/{code}")
	public ResponseEntity<Product> isProduct(@PathVariable Long code) throws Exception {
		
		Product p1 = new Product(code, "Product 1", "It's is product 1");
		// Product p2 = new Product(code, "Product 2", "It's is product 2");
		// Product p3 = new Product(code, "Product 3", "It's is product 3");
		
		Thread.sleep(3000); // Require throws
		
		// List<Product> list = Arrays.asList(p1, p2, p3);
		
		return ResponseEntity.ok(p1);
		
	}
	
}
