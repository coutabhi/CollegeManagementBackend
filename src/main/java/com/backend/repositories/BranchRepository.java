package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.models.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Integer>{

}
