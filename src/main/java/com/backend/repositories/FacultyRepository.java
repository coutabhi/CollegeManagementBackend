package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.models.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer>{
	

}
