package com.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.models.Event;
import com.backend.repositories.EventRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository eventRepository;

	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	public Event getEventById(Long id) {
		return eventRepository.findById(id).orElse(null);
	}

	public Event saveEvent(Event event) {
		return eventRepository.save(event);
	}

	public void deleteEvent(Long id) {
		eventRepository.deleteById(id);
	}
}
