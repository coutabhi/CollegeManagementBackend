package com.backend.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.models.EEStudent;
import com.backend.repositories.EEStudentRepository;

@Service
public class EEStudentService {

	@Autowired
	EEStudentRepository eeStudentRepo;

	public EEStudentService() {
	}

	public List<EEStudent> getAllLogin() {
		return eeStudentRepo.findAll();
	}

	public void saveStudent(EEStudent ll) {
		eeStudentRepo.save(ll);
	}

	public void updateStudent(EEStudent ll1) {
		eeStudentRepo.save(ll1);
	}

	/*
	 * public void deleteStudentById(int id) { StudentModel ss=sd.getOne(id);
	 * sd.delete(ss); }
	 */

	public void deleteStudent(EEStudent id) {
		eeStudentRepo.delete(id);
	}

	public EEStudent getStudentById(int id) {
		Optional<EEStudent> pm = eeStudentRepo.findById(id);
		if (pm.isPresent()) {
			return pm.get();
		} else
			return null;
	}

	public void saveUser(EEStudent ll) {
		eeStudentRepo.save(ll);
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
