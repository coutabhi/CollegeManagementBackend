package com.backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.backend.models.Student;
import com.backend.repositories.StudentRepository;
import com.backend.services.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	
	@Autowired
	StudentService l;

	//GET
	//@RequestMapping(value="/login",method=RequestMethod.GET)
	@GetMapping("viewstudent")
	public List<Student> getLogin() {
		return l.getAllLogin();
	}

	@PostMapping("view")
	public Student getStudent(@RequestBody Student id) {
		int id1 = id.getId();
		return l.getStudentById(id1);
	}

	//POST
	//@RequestMapping(value="/save",method=RequestMethod.POST)
	@PostMapping("addstudent")
	public void saveL(@RequestBody Student ll) {
		l.saveStudent(ll);
	}

	@PostMapping("updatestudent")
	public void updateL(@RequestBody Student ll) {
		l.updateStudent(ll);
	}

	@PostMapping("deletestudent")
	public void deleteL(@RequestBody Student id) {
		l.deleteStudent(id);
	}

	@Autowired
	private StudentRepository gDOA;

	@PostMapping("loginstudent")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> loginUser(@RequestBody Student userData) {
		Student user = gDOA.findByEmail(userData.getEmail());
		System.out.println(user);
		if (user.getPassword().equals(userData.getPassword()))
			return ResponseEntity.ok(user);
		return (ResponseEntity<?>) ResponseEntity.internalServerError();
	}

	//@PostMapping("insert")
	//@CrossOrigin(origins="http://localhost:4200")
	//public void save(@RequestBody Student ll)throws Exception {
	//	String tempEmailId=ll.getEmailid();
	//	if(tempEmailId != null && !"".equals(tempEmailId)) {
	//		Student llobj=l.fetchUserByEmail(tempEmailId);
	//		if(llobj !=null) {
	//			throw new Exception("user with"+tempEmailId+"already exist");
	//		}
	//	}
	//	
	//	l.saveUser(ll);
	//
	//}

}
