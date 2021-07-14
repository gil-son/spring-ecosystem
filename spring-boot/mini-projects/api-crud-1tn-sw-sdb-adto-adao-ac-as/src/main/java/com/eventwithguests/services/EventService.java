package com.eventwithguests.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventwithguests.dto.EventDTO;
import com.eventwithguests.dto.GuestDTO;
import com.eventwithguests.entities.Event;
import com.eventwithguests.entities.Guest;
import com.eventwithguests.repository.EventRepository;
import com.eventwithguests.repository.GuestRepository;

@Service
public class EventService {

	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	GuestRepository guestRepository;
	
	public EventDTO insert(EventDTO dto) {
		Event entity = new Event();
		
		entity.setdescription(dto.getDescription());
		entity.setLocal(dto.getLocal());
		
		entity.getGuests().clear();
		
		for(GuestDTO guestDTO : dto.getGuest()) {
			Guest guest = guestRepository.getById(guestDTO.getId());
			entity.getGuests().add(guest);
		}
		
		entity = eventRepository.save(entity);
		
		return new EventDTO(entity);
	}
}
