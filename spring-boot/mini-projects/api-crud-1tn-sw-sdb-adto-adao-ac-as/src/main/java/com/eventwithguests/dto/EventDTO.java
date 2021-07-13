package com.eventwithguests.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.eventwithguests.entities.Event;
import com.eventwithguests.entities.Guest;

public class EventDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	

	private Integer id;
	private String description;
	private String local;
	private List<GuestDTO> guestsDTO = new ArrayList<>();
	
	public EventDTO(String description, String local) {
		this.description = description;
		this.local = local;
	}
	
	public EventDTO(Event e) {
		this.description = e.getdescription();
		this.local = e.getLocal();
	}
	
	public EventDTO(Event e, List<Guest> guests) {
		this(e); // this call the constructor EventDTO(Event e)
		
		for(Guest one : guests ) {
			guestsDTO.add(new GuestDTO(one));
		}
	}

	public String getdescription() {return description;}

	public void setdescription(String description) {this.description = description;}

	public String getLocal() {return local;}

	public void setLocal(String local) {this.local = local;}
	
	public List<GuestDTO> getList(){return guestsDTO;}
	
	
}
