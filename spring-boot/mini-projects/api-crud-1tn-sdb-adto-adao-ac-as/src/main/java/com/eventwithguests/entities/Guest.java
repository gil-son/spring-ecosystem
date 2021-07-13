package com.eventwithguests.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Guest {

	@Id
	private Integer id;
	private String name;
	private String local;
	
	@ManyToOne
	private Event event;
	
	public Guest() {}
	
	public Guest(String name, String local) {
		this.name = name;
		this.local = local;
	}

	public String getName() {return name;}

	public void setName(String name) {this.name = name;}

	public String getLocal() {return local;}

	public void setLocal(String local) {this.local = local;}
	
	
	
}
