package com.backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.backend.models.Branch;
import com.backend.services.BranchService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BranchController {

	@Autowired
	BranchService l;

	//GET
	//@RequestMapping(value="/login",method=RequestMethod.GET)
	@GetMapping("viewbranch")
	public List<Branch> getLogin() {
		return l.getAllLogin();
	}

	//POST
	//@RequestMapping(value="/save",method=RequestMethod.POST)
	@PostMapping("addbranch")
	public void saveL(@RequestBody Branch ll) {
		l.saveStudent(ll);
	}

	@PostMapping("updatebranch")
	public void updateL(@RequestBody Branch ll) {
		l.updateStudent(ll);
	}

	@PostMapping("deletebranch")
	public void deleteL(@RequestBody Branch id) {
		l.deleteStudent(id);
	}

}
