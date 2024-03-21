package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.models.EEStudent;

@Repository
public interface EEStudentRepository extends JpaRepository<EEStudent,Integer>{
	
	EEStudent findByEmail(String email);
	
}
