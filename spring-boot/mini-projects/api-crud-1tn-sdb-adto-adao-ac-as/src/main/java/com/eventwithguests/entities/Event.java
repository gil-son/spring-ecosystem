package com.eventwithguests.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Event {
	
	@Id
	private Integer id;
	private String name;
	private String local;
	
	@OneToMany
	private List<Guest> guests = new ArrayList<>();
	
	public Event() {}
	
	public Event(String name, String local) {
		this.name = name;
		this.local = local;
	}

	public String getName() {return name;}

	public void setName(String name) {this.name = name;}

	public String getLocal() {return local;}

	public void setLocal(String local) {this.local = local;}
	
	
	
}
