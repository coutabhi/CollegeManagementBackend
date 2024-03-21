package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.models.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer>{

	Staff findByEmail(String email);
	
}
