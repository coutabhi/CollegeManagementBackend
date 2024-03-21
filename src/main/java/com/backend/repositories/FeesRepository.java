package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.models.Fees;

@Repository
public interface FeesRepository extends JpaRepository<Fees,Integer>{

}
