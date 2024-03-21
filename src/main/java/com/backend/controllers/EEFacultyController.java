package com.backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.backend.models.EEFaculty;
import com.backend.repositories.EEFacultyRepository;
import com.backend.services.EEFacultyService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EEFacultyController {

	@Autowired
	EEFacultyService l;

	// GET
	// @RequestMapping(value="/login",method=RequestMethod.GET)
	@GetMapping("vieweefaculty")
	public List<EEFaculty> getLogin() {
		return l.getAllLogin();
	}

	@PostMapping("vieweef")
	public EEFaculty getStudent(@RequestBody EEFaculty id) {
		int id1 = id.getId();
		return l.getStudentById(id1);
	}

	// POST
	// @RequestMapping(value="/save",method=RequestMethod.POST)
	@PostMapping("addeefaculty")
	public void saveL(@RequestBody EEFaculty ll) {
		l.saveStudent(ll);
	}

	@PostMapping("updateeefaculty")
	public void updateL(@RequestBody EEFaculty ll) {
		l.updateStudent(ll);
	}

	@PostMapping("deleteeefaculty")
	public void deleteL(@RequestBody EEFaculty id) {
		l.deleteStudent(id);
	}

	@Autowired
	private EEFacultyRepository gDOA;

	@PostMapping("logineefaculty")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> loginUser(@RequestBody EEFaculty facultyData) {
		EEFaculty faculty = gDOA.findByEmail(facultyData.getEmail());
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
