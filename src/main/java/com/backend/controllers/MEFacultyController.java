package com.backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.backend.models.MEFaculty;
import com.backend.repositories.MEFacultyRepository;
import com.backend.services.MEFacultyService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MEFacultyController {
	
	@Autowired
	MEFacultyService l;

	//GET
	//@RequestMapping(value="/login",method=RequestMethod.GET)
	@GetMapping("viewmefaculty")
	public List<MEFaculty> getLogin() {
		return l.getAllLogin();
	}

	@PostMapping("viewmef")
	public MEFaculty getStudent(@RequestBody MEFaculty id) {
		int id1 = id.getId();
		return l.getStudentById(id1);
	}

	//POST
	//@RequestMapping(value="/save",method=RequestMethod.POST)
	@PostMapping("addmefaculty")
	public void saveL(@RequestBody MEFaculty ll) {
		l.saveStudent(ll);
	}

	@PostMapping("updatemefaculty")
	public void updateL(@RequestBody MEFaculty ll) {
		l.updateStudent(ll);
	}

	@PostMapping("deletemefaculty")
	public void deleteL(@RequestBody MEFaculty id) {
		l.deleteStudent(id);
	}

	@Autowired
	private MEFacultyRepository gDOA;

	@PostMapping("loginmefaculty")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> loginUser(@RequestBody MEFaculty facultyData) {
		MEFaculty faculty = gDOA.findByEmail(facultyData.getEmail());
		System.out.println(faculty);
		if (faculty.getPassword().equals(facultyData.getPassword()))
			return ResponseEntity.ok(faculty);
		return (ResponseEntity<?>) ResponseEntity.internalServerError();
	}

	//@PostMapping("insert")
	//@CrossOrigin(origins="http://localhost:4200")
	//public void save(@RequestBody StudentModel ll)throws Exception {
	//	String tempEmailId=ll.getEmailid();
	//	if(tempEmailId != null && !"".equals(tempEmailId)) {
	//		StudentModel llobj=l.fetchUserByEmail(tempEmailId);
	//		if(llobj !=null) {
	//			throw new Exception("user with"+tempEmailId+"already exist");
	//		}
	//	}
	//	
	//	l.saveUser(ll);
	//
	//}

}
