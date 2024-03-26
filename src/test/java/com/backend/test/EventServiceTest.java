package com.backend.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.backend.models.Event;
import com.backend.repositories.EventRepository;
import com.backend.services.EventService;

public class EventServiceTest {

	@InjectMocks
	private EventService eventService;

	@Mock
	private EventRepository eventRepository;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllEvents() {
		// Create a sample list of events
		List<Event> events = new ArrayList<>();
		events.add(new Event(1L, "Event 1", null, "Location 1", "Description 1"));
		events.add(new Event(2L, "Event 2", null, "Location 2", "Description 2"));

		// Mock the behavior of eventRepository.findAll() to return the sample list
		when(eventRepository.findAll()).thenReturn(events);

		// Call the service method
		List<Event> result = eventService.getAllEvents();

		// Verify that the result is as expected
		assertEquals(events, result);
	}

	@Test
	public void testGetEventById() {
		Long eventId = 1L;
		Event event = new Event(eventId, "Event 1", null, "Location 1", "Description 1");

		// Mock the behavior of eventRepository.findById() to return an Optional
		// containing the event
		when(eventRepository.findById(eventId)).thenReturn(Optional.of(event));

		// Call the service method
		Event result = eventService.getEventById(eventId);

		// Verify that the result is as expected
		assertEquals(event, result);
	}

	@Test
	public void testSaveEvent() {
		Event eventToSave = new Event(null, "New Event", null, "Location", "Description");

		// Mock the behavior of eventRepository.save() to return the saved event
		Event savedEvent = new Event(1L, "New Event", null, "Location", "Description");
		when(eventRepository.save(eventToSave)).thenReturn(savedEvent);

		// Call the service method
		Event result = eventService.saveEvent(eventToSave);

		// Verify that the result is as expected
		assertEquals(savedEvent, result);
	}

	@Test
	public void testDeleteEvent() {
		Long eventId = 1L;

		// Mock the behavior of eventRepository.existsById() to return true
		when(eventRepository.existsById(eventId)).thenReturn(true);

		// Call the service method
		eventService.deleteEvent(eventId);

		// correct argument
		verify(eventRepository, times(1)).deleteById(eventId);
	}
}
