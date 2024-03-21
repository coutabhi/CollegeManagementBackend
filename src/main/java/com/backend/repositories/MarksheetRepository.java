package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.models.Marksheet;

@Repository
public interface MarksheetRepository extends JpaRepository<Marksheet,Integer>{

}
