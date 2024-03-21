package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

	Student findByEmail(String email);
	
}
