package com.eventwithguests.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_guest")
public class Guest implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

	@ManyToOne
	private Event event;
	
	public Guest() {}
	
	public Guest(String name, String local) {
		this.name = name;
	}

	public String getName() {return name;}

	public void setName(String name) {this.name = name;}
	
	public Event getEvent() { return event;}
	
	public void setEvent(Event event) { this.event = event;}

}
