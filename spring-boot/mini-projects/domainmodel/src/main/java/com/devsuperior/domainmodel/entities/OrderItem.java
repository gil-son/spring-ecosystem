package com.devsuperior.domainmodel.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_order_item")
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	private Integer quantity;
	private Double price;
	
	@ManyToOne // OrderItem has ManyToOne to Product
	@JoinColumn(name="product_id")
	private Product product;
	
	/* To avoid loop is used @JsonIgnore (technique). Its will blocked the sereliaze of object JSON in web service, when you will take a order. 
		So OrderItem don't will serealize the Order, then Ordem stop cycle. But Order access OrdemItem, because don't stop, don't use @JsonIgnore
	*/
	@JsonIgnore 
	@ManyToOne // OrderItem has ManyToOne to Order
	@JoinColumn(name="order_id")
	private Order order;
	
	public OrderItem() {}

	public OrderItem(Integer id, Integer quantity, Double price, Product product, Order order) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.product = product;
		this.order = order;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public double getTheSubTotal() { // require use get to emerge
		return quantity * price;
	}
	
}
