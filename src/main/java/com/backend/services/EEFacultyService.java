package com.backend.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.models.EEFaculty;
import com.backend.repositories.EEFacultyRepository;

@Service
public class EEFacultyService {

	@Autowired
	EEFacultyRepository eeFacultyRepo;

	public EEFacultyService() {
	}

	public List<EEFaculty> getAllLogin() {
		return eeFacultyRepo.findAll();
	}

	public void saveStudent(EEFaculty ll) {
		eeFacultyRepo.save(ll);
	}

	public void updateStudent(EEFaculty ll1) {
		eeFacultyRepo.save(ll1);
	}

	public void deleteStudent(EEFaculty id) {
		eeFacultyRepo.delete(id);
	}

	public EEFaculty getStudentById(int id) {
		Optional<EEFaculty> pm = eeFacultyRepo.findById(id);
		if (pm.isPresent()) {
			return pm.get();
		} else
			return null;
	}

	public void saveUser(EEFaculty ll) {
		eeFacultyRepo.save(ll);
	}

//	public StudentModel fetchUserByEmail(String email) {
//		// TODO Auto-generated method stub
//		return ld.findByEmail(email);
//	}	
//	
//	public StudentModel fetchUserByEmailAndPassword(String email,String password) {
//		// TODO Auto-generated method stub
//		return ld.findByEmailAndPassword(email,password);
//	}

}
