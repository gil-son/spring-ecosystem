package com.eventwithguests.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventwithguests.dto.EventDTO;
import com.eventwithguests.services.EventService;

@RestController
@RequestMapping(value = "/events")
public class EventResource {

	private EventService eventService;
	
	public EventResource(EventService eventService) {
		this.eventService = eventService;
	}
	
	
	@PostMapping
	public ResponseEntity<EventDTO> insert(@RequestBody EventDTO dto){
		
		return null;
	}
	
	
	@GetMapping
	public String test() {
		return "Test";
	}
	
	
	
}
