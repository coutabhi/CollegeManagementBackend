package com.backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.backend.models.Marksheet;
import com.backend.services.MarksheetService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MarksheetController {

	@Autowired
	MarksheetService l;

	// GET
	// @RequestMapping(value="/login",method=RequestMethod.GET)
	@GetMapping("viewmemarksheet")
	public List<Marksheet> getLogin() {
		return l.getAllLogin();
	}

	// @PostMapping("viewmem")
	// public Marksheet getStudent(@RequestBody Marksheet id) {
	// String id1=id.getEmail();
	// return l.getStudentById(id1);
	// }

	// POST
	// @RequestMapping(value="/save",method=RequestMethod.POST)
	@PostMapping("addmemarksheet")
	public void saveL(@RequestBody Marksheet ll) {
		l.saveStudent(ll);
	}

	@PostMapping("updatememarksheet")
	public void updateL(@RequestBody Marksheet ll) {
		l.updateStudent(ll);
	}

	@PostMapping("deletememarksheet")
	public void deleteL(@RequestBody Marksheet id) {
		l.deleteStudent(id);
	}

	// @Autowired
	// private StudentDAO gDOA;
	// @PostMapping("loginstudent")
	// @CrossOrigin(origins="http://localhost:4200")
	// public ResponseEntity<?>loginUser(@RequestBody StudentModel userData){
	// StudentModel user=gDOA.findByEmail(userData.getEmail());
	// System.out.println(user);
	// if(user.getPassword().equals(userData.getPassword()))
	// return ResponseEntity.ok(user);
	// return (ResponseEntity<?>) ResponseEntity.internalServerError();
	// }
	//

	// @PostMapping("insert")
	// @CrossOrigin(origins="http://localhost:4200")
	// public void save(@RequestBody StudentModel ll)throws Exception {
	// String tempEmailId=ll.getEmailid();
	// if(tempEmailId != null && !"".equals(tempEmailId)) {
	// StudentModel llobj=l.fetchUserByEmail(tempEmailId);
	// if(llobj !=null) {
	// throw new Exception("user with"+tempEmailId+"already exist");
	// }
	// }
	//
	// l.saveUser(ll);
	//
	// }

}
