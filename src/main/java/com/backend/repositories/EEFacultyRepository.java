package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.models.EEFaculty;

@Repository
public interface EEFacultyRepository extends JpaRepository<EEFaculty,Integer>{

	EEFaculty findByEmail(String email);

}
