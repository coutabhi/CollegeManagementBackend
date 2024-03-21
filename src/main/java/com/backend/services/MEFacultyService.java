package com.backend.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.models.MEFaculty;
import com.backend.repositories.MEFacultyRepository;

@Service
public class MEFacultyService {

	@Autowired
	MEFacultyRepository meFacultyRepo;

	public MEFacultyService() {
	}

	public List<MEFaculty> getAllLogin() {
		return meFacultyRepo.findAll();
	}

	public void saveStudent(MEFaculty ll) {
		meFacultyRepo.save(ll);
	}

	public void updateStudent(MEFaculty ll1) {
		meFacultyRepo.save(ll1);
	}

	/*
	 * public void deleteStudentById(int id) { StudentModel ss=sd.getOne(id);
	 * sd.delete(ss); }
	 */

	public void deleteStudent(MEFaculty id) {
		meFacultyRepo.delete(id);

	}

	public MEFaculty getStudentById(int id) {
		Optional<MEFaculty> pm = meFacultyRepo.findById(id);
		if (pm.isPresent()) {
			return pm.get();
		} else
			return null;
	}

	public void saveUser(MEFaculty ll) {
		meFacultyRepo.save(ll);
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
