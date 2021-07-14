package com.eventwithguests.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_event")
public class Event implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String description;
	private String local;
	
	@OneToMany
	private List<Guest> guests = new ArrayList<>();
	
	public Event() {}
	
	public Event(String description, String local) {
		this.description = description;
		this.local = local;
	}

	public String getdescription() {return description;}

	public void setdescription(String description) {this.description = description;}

	public String getLocal() {return local;}

	public void setLocal(String local) {this.local = local;}

	public List<Guest> getGuests() {return guests;}

	public void setGuests(List<Guest> guests) {this.guests = guests;}
	
	
	
}
