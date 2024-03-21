package com.backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.backend.models.CEFaculty;
import com.backend.repositories.CEFacultyRepository;
import com.backend.services.CEFacultyService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CEFacultyController {

	@Autowired
	CEFacultyService l;

	// GET
	// @RequestMapping(value="/login",method=RequestMethod.GET)
	@GetMapping("viewcefaculty")
	public List<CEFaculty> getLogin() {
		return l.getAllLogin();
	}

	@PostMapping("viewcef")
	public CEFaculty getStudent(@RequestBody CEFaculty id) {
		int id1 = id.getId();
		return l.getStudentById(id1);
	}

	// POST
	// @RequestMapping(value="/save",method=RequestMethod.POST)
	@PostMapping("addcefaculty")
	public void saveL(@RequestBody CEFaculty ll) {
		l.saveStudent(ll);
	}

	@PostMapping("updatecefaculty")
	public void updateL(@RequestBody CEFaculty ll) {
		l.updateStudent(ll);
	}

	@PostMapping("deletecefaculty")
	public void deleteL(@RequestBody CEFaculty id) {
		l.deleteStudent(id);
	}

	@Autowired
	private CEFacultyRepository gDOA;

	@PostMapping("logincefaculty")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> loginUser(@RequestBody CEFaculty facultyData) {
		CEFaculty faculty = gDOA.findByEmail(facultyData.getEmail());
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
