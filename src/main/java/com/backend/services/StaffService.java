package com.backend.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.models.Staff;
import com.backend.repositories.StaffRepository;

@Service
public class StaffService {

	@Autowired
	StaffRepository staffRepo;

	public StaffService() {}

	public List<Staff> getAllLogin() {
		return staffRepo.findAll();
	}

	public void saveStudent(Staff ll) {
		staffRepo.save(ll);
	}

	public void updateStudent(Staff ll1) {
		staffRepo.save(ll1);
	}

	/*
	 * public void deleteStudentById(int id) { StudentModel ss=sd.getOne(id);
	 * sd.delete(ss); }
	 */

	public void deleteStudent(Staff id) {
		staffRepo.delete(id);
	}

	public Staff getStudentById(int id) {
		Optional<Staff> pm = staffRepo.findById(id);
		if (pm.isPresent()) {
			return pm.get();
		} else
			return null;
	}

	public void saveUser(Staff ll) {
		staffRepo.save(ll);
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
