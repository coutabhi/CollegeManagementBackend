package com.backend.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.models.CEStudent;
import com.backend.repositories.CEStudentRepository;

@Service
public class CEStudentService {

	@Autowired
	CEStudentRepository ceStudentRepo;

	public CEStudentService() {}

	public List<CEStudent> getAllLogin() {
		return ceStudentRepo.findAll();
	}

	public void saveStudent(CEStudent ll) {
		ceStudentRepo.save(ll);
	}

	public void updateStudent(CEStudent ll1) {
		ceStudentRepo.save(ll1);
	}

	/*
	 * public void deleteStudentById(int id) { StudentModel ss=sd.getOne(id);
	 * sd.delete(ss); }
	 */

	public void deleteStudent(CEStudent id) {
		ceStudentRepo.delete(id);
	}

	public CEStudent getStudentById(int id) {
		Optional<CEStudent> pm = ceStudentRepo.findById(id);
		if (pm.isPresent()) {
			return pm.get();
		} else
			return null;
	}

	public void saveUser(CEStudent ll) {
		ceStudentRepo.save(ll);
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
