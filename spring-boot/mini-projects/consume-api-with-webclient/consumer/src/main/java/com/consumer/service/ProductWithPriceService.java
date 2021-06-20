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
	
	public ProductWithPrice ProductWithPriceService(Long codeProduct) {
		
	Mono<ProductWithPrice> monoProduct = this.webClient
		.method(HttpMethod.GET)
		.uri("/products/{code}", codeProduct)
		.retrieve()
		.bodyToMono(ProductWithPrice.class);
		
		monoProduct.subscribe(p -> {
			System.out.println("Actually/In fact, here it really was finished!");
		});
		
		System.out.println("Finalized");
		return null;
	}
	
}
