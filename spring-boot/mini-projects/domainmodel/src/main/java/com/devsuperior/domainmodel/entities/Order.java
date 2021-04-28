package com.devsuperior.domainmodel.entities;

import java.time.Instant;
import java.util.List; // Interface. Interface can't be instantiated
import java.util.ArrayList; // Is a Inheritance of List


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Instant moment;
	private OrderStatus status;
	
	@ManyToOne // Association IS-A to client
	@JoinColumn(name="client_id") // Specify the name of foreign key
	private Client client; 
	
	
	
	
	// Warning! Two way street ! Cyclic reference! To avoid loop is used @JsonIgnore in the other side (technique)
	// Relation to Many, use Set or List
	@OneToMany(mappedBy = "order") // Order has OneToMany to OrderItems //mappedBy = name of attribute the other side and will make the relation
	private List<OrderItem> items = new ArrayList<>();
	
	public void startOrdemItem(int quantity, double price, Product p, Order o) {
		
		OrderItem oi = new OrderItem(null, quantity, price, p, o);
		items.add(oi);
	}
	
	
	
	public Order() {}

	public Order(Integer id, Instant moment, OrderStatus status, Client client) {
		super();
		this.id = id;
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	
	
	// In Collection is rare use method 'set()', because is just necessary get the list. So just use method 'get()'
	public List<OrderItem> getItems() {
		return items;
	}
	
	public double getTheTotal() {
		double sum = 0;
		for( OrderItem item : items) {
			sum += item.getTheSubTotal();
		}
		return sum;
	}
	
}
