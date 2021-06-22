package com.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.consumer.model.ProductWithPrice;

import reactor.core.publisher.Mono;

@Service
public class ProductWithPriceService {

	@Autowired
	private WebClient webClient;
	
	public ProductWithPrice webClientProductWithPriceService(Long code) {
	
		// 3 seconds
		Mono<ProductWithPrice> monoProduct = this.webClient
		.method(HttpMethod.GET)
		.uri("/products/{code}", code)
		.retrieve()
		.bodyToMono(ProductWithPrice.class);
		
		// http://localhost:8081/products/{code} localhost:8081/products/1
	
		// 3 seconds
		
		// Other Mono
		
		
		// more logic...
		 ProductWithPrice productWithPrice = monoProduct.block();
		
	
		return productWithPrice;
	}
	
}
