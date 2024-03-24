package com.backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.backend.models.EEStudent;
import com.backend.repositories.EEStudentRepository;
import com.backend.services.EEStudentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EEStudentController {
	
	@Autowired
	EEStudentService l;

	//GET
	//@RequestMapping(value="/login",method=RequestMethod.GET)
	@GetMapping("vieweestudent")
	public List<EEStudent> getLogin() {

		return l.getAllLogin();

	}

	@PostMapping("viewee")
	public EEStudent getStudent(@RequestBody EEStudent id) {
		int id1 = id.getId();
		return l.getStudentById(id1);
	}

	//POST
	//@RequestMapping(value="/save",method=RequestMethod.POST)
	@PostMapping("addeestudent")
	public void saveL(@RequestBody EEStudent ll) {
		l.saveStudent(ll);
	}

	@PostMapping("updateeestudent")
	public void updateL(@RequestBody EEStudent ll) {
		l.updateStudent(ll);
	}

	@PostMapping("deleteeestudent")
	public void deleteL(@RequestBody EEStudent id) {
		l.deleteStudent(id);
	}

	@Autowired
	private EEStudentRepository gDOA;

	@PostMapping("logineestudent")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> loginUser(@RequestBody EEStudent userData) {
		EEStudent user = gDOA.findByEmail(userData.getEmail());
		System.out.println(user);
		if (user.getPassword().equals(userData.getPassword()))
			return ResponseEntity.ok(user);
		return (ResponseEntity<?>) ResponseEntity.internalServerError();
	}

}
