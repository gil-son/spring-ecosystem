package com.eventwithguests.resources;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		dto = eventService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	
	@GetMapping
	public String test() {
		return "Test";
	}
	
	
	
}
