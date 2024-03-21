package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.models.CEStudent;

@Repository
public interface CEStudentRepository extends JpaRepository<CEStudent,Integer>{

	CEStudent findByEmail(String email);

}
