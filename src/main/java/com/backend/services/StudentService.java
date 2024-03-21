package com.backend.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.models.Student;
import com.backend.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepo;

	public StudentService() {
	}

	public List<Student> getAllLogin() {
		return studentRepo.findAll();
	}

	public void saveStudent(Student ll) {
		studentRepo.save(ll);
	}

	public void updateStudent(Student ll1) {
		studentRepo.save(ll1);
	}

	/*
	 * public void deleteStudentById(int id) { StudentModel ss=sd.getOne(id);
	 * sd.delete(ss); }
	 */

	public void deleteStudent(Student id) {
		studentRepo.delete(id);
	}

	public Student getStudentById(int id) {
		Optional<Student> pm = studentRepo.findById(id);
		if (pm.isPresent()) {
			return pm.get();
		} else
			return null;
	}

	public void saveUser(Student ll) {
		studentRepo.save(ll);
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
