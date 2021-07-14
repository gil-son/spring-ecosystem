package com.eventwithguests.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventwithguests.dto.EventDTO;
import com.eventwithguests.entities.Event;

@Service
public class EventService {

	@Autowired
	EventService eventService;
	
	public EventDTO insert(EventDTO dto) {
		Event entity = new Event();
		
		entity.setdescription(dto.getDescription());
		entity.setLocal(dto.getLocal());
		
		entity.getGuests().clear();
		
		return null;
	}
}
