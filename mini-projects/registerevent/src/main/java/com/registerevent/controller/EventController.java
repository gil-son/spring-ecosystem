package com.registerevent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventController {
	
	@RequestMapping("/scheduleevent")
	public String form() {
		return "event/formEvent";
	}
}
