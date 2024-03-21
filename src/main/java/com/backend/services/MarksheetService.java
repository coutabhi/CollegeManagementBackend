package com.backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.models.Marksheet;
import com.backend.repositories.MarksheetRepository;

@Service
public class MarksheetService {

	@Autowired
	MarksheetRepository marksheetRepo;

	public MarksheetService() {
	}

	public List<Marksheet> getAllLogin() {
		return marksheetRepo.findAll();
	}

	public void saveStudent(Marksheet ll) {
		marksheetRepo.save(ll);
	}

	public void updateStudent(Marksheet ll1) {
		marksheetRepo.save(ll1);
	}

	/*
	 * public void deleteStudentById(int id) { StudentModel ss=sd.getOne(id);
	 * sd.delete(ss); }
	 */

	public void deleteStudent(Marksheet id) {
		marksheetRepo.delete(id);
	}

//	public StudentModel getStudentById(String email) {
//		Optional<StudentModel> pm=ld.findById(email);
//		if(pm.isPresent()) {
//			//System.out.println(pm.get().getName());
//			return pm.get();
//		}else 
//		return null;
//		 
//	}

//	public void saveUser(StudentModel ll) {
//		// TODO Auto-generated method stub
//		ld.save(ll);
//		
//	}

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
