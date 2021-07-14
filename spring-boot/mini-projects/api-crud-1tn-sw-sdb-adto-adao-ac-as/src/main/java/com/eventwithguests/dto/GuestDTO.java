package com.eventwithguests.dto;

import java.io.Serializable;

import com.eventwithguests.entities.Event;
import com.eventwithguests.entities.Guest;


public class GuestDTO implements Serializable{
	private static final long serialVersionUID = 1L;


	private Integer id;
	private String name;
	private EventDTO eventDTO;
	
	public GuestDTO() {}
	
	public GuestDTO(String name, String local) {
		this.name = name;
	}
	
	public GuestDTO(Guest entity) {
		this.name = entity.getName();

	}
	
	public GuestDTO(Guest entity, Event event) {
		this(entity);
		this.eventDTO = new EventDTO(event);
	}

	
	public Integer getId() {return id;}

	public void setId(Integer id) {this.id = id;}

	public String getName() {return name;}

	public void setName(String name) {this.name = name;}
	
	public EventDTO getEventDTO() {return eventDTO;}
	
	public void setEventDTO(EventDTO eventDTO) {this.eventDTO = eventDTO;}

}
