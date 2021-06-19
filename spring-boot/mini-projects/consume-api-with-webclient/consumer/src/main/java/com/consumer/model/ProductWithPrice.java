package com.consumer.model;

import java.math.BigDecimal;

public class ProductWithPrice {
	
	private Long code;
	private String name;
	private BigDecimal price;
	
	ProductWithPrice(){}

	public ProductWithPrice(Long code, String name, BigDecimal price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
