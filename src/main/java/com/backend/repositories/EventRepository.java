package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.models.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
