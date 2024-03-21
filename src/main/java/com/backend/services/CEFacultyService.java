package com.backend.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.models.CEFaculty;
import com.backend.repositories.CEFacultyRepository;

@Service
public class CEFacultyService {

	@Autowired
	CEFacultyRepository ceFacultyRepo;

	public CEFacultyService() {}

	public List<CEFaculty> getAllLogin() {
		return ceFacultyRepo.findAll();
	}

	public void saveStudent(CEFaculty ll) {
		ceFacultyRepo.save(ll);
	}

	public void updateStudent(CEFaculty ll1) {
		ceFacultyRepo.save(ll1);
	}

	/*
	 * public void deleteStudentById(int id) { StudentModel ss=sd.getOne(id);
	 * sd.delete(ss); }
	 */

	public void deleteStudent(CEFaculty id) {
		ceFacultyRepo.delete(id);
	}

	public CEFaculty getStudentById(int id) {
		Optional<CEFaculty> pm = ceFacultyRepo.findById(id);
		if (pm.isPresent()) {
			// System.out.println(pm.get().getName());
			return pm.get();
		} else
			return null;
	}

	public void saveUser(CEFaculty ll) {
		ceFacultyRepo.save(ll);
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
