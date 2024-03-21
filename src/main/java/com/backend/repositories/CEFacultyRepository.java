package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.models.CEFaculty;

@Repository
public interface CEFacultyRepository extends JpaRepository<CEFaculty,Integer>{

	CEFaculty findByEmail(String email);
	
}
