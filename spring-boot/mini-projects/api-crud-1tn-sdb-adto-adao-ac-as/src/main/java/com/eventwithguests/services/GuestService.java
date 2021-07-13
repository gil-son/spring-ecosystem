package com.eventwithguests.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventwithguests.repository.GuestRepository;

@Service
public class GuestService {
	
	@Autowired
	GuestRepository guestRepository;
	
	
}
