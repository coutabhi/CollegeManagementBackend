package com.backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.models.Fees;
import com.backend.repositories.FeesRepository;

@Service
public class FeesService {

	@Autowired
	FeesRepository feesRepo;

	public FeesService() {}

	public List<Fees> getAllLogin() {
		return feesRepo.findAll();
	}

	public void saveStudent(Fees ll) {
		feesRepo.save(ll);
	}

}
