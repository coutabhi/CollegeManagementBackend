package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.models.MEFaculty;

@Repository
public interface MEFacultyRepository extends JpaRepository<MEFaculty,Integer>{

	MEFaculty findByEmail(String email);

}
