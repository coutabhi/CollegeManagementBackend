package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.models.BookAssignment;

public interface BookAssignmentRepository extends JpaRepository<BookAssignment, Integer>{

}
