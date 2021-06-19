package com.price.model;

import java.math.BigDecimal;

public class Price {
	
	private Long codeProduct;
	private BigDecimal price;
	
	Price(){}
	
	public Price(Long codeProduct, BigDecimal price) {
		this.codeProduct = codeProduct;
		this.price = price;
	}
	
	public Long getCodeProduct() {
		return codeProduct;
	}
	public void setCodeProduct(Long codeProduct) {
		this.codeProduct = codeProduct;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
