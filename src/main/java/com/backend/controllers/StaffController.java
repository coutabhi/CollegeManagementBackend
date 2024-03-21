package com.backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.backend.models.Staff;
import com.backend.repositories.StaffRepository;
import com.backend.services.StaffService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StaffController {

	@Autowired
	StaffService l;

	// GET
	// @RequestMapping(value="/login",method=RequestMethod.GET)
	@GetMapping("viewstaff")
	public List<Staff> getLogin() {
		return l.getAllLogin();
	}

	@PostMapping("viewstaffI")
	public Staff getStudent(@RequestBody Staff id) {
		int id1 = id.getId();
		return l.getStudentById(id1);
	}

	//POST
	//@RequestMapping(value="/save",method=RequestMethod.POST)
	@PostMapping("addstaff")
	public void saveL(@RequestBody Staff ll) {
		l.saveStudent(ll);
	}

	@PostMapping("updatestaff")
	public void updateL(@RequestBody Staff ll) {
		l.updateStudent(ll);
	}

	@PostMapping("deletestaff")
	public void deleteL(@RequestBody Staff id) {
		l.deleteStudent(id);
	}

	@Autowired
	private StaffRepository gDOA;

	@PostMapping("loginstaff")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> loginUser(@RequestBody Staff userData) {
		Staff user = gDOA.findByEmail(userData.getEmail());
		System.out.println(user);
		if (user.getPassword().equals(userData.getPassword()))
			return ResponseEntity.ok(user);
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
