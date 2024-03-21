package com.backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.backend.models.Fees;
import com.backend.services.FeesService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FeesController {
	
	@Autowired
	FeesService l;

	//GET
	//@RequestMapping(value="/login",method=RequestMethod.GET)
	@GetMapping("viewfees")
	public List<Fees> getLogin() {
		return l.getAllLogin();
	}

	//@PostMapping("view")
	//public Fees getStudent(@RequestBody Fees id) {
	//	String id1=id.getEmail();
	//	return l.getStudentById(id1);
	//}

	//POST
	//@RequestMapping(value="/save",method=RequestMethod.POST)
	@PostMapping("addfees")
	public void saveL(@RequestBody Fees ll) {
		l.saveStudent(ll);
	}

}
