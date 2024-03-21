package com.backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.models.Branch;
import com.backend.repositories.BranchRepository;

@Service
public class BranchService {

	@Autowired
	BranchRepository branchRepo;

	public BranchService() {}

	public List<Branch> getAllLogin() {
		return branchRepo.findAll();
	}

	public void saveStudent(Branch ll) {
		branchRepo.save(ll);
	}

	public void updateStudent(Branch ll1) {
		branchRepo.save(ll1);
	}

	public void deleteStudent(Branch id) {
		branchRepo.delete(id);
	}

}
