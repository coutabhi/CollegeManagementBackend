package com.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.models.Event;
import com.backend.services.EventService;

@RestController
@RequestMapping("/api/v1/events")
@CrossOrigin(origins = "http://localhost:4200")
public class EventController {
	 @Autowired
	    private EventService eventService;

	    @GetMapping
	    public ResponseEntity<List<Event>> getAllEvents() {
	        List<Event> events = eventService.getAllEvents();
	        return new ResponseEntity<>(events, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
	        Event event = eventService.getEventById(id);
	        return new ResponseEntity<>(event, HttpStatus.OK);
	    }

	    @PostMapping
	    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
	        Event createdEvent = eventService.saveEvent(event);
	        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
	        eventService.deleteEvent(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) {
	        Event existingEvent = eventService.getEventById(id);
	        
	        if (existingEvent == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        
	        existingEvent.setName(updatedEvent.getName());
	        existingEvent.setDate(updatedEvent.getDate());
	        existingEvent.setLocation(updatedEvent.getLocation());
	        existingEvent.setDescription(updatedEvent.getDescription());

	        Event updated = eventService.saveEvent(existingEvent);
	        return new ResponseEntity<>(updated, HttpStatus.OK);
	    }
}
