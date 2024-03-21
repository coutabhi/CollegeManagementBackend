package com.backend.controllers;

import com.backend.models.Admin;
import com.backend.repositories.AdminRepository;
import com.backend.services.AdminService;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	private final AdminService adminService;

	private final AdminRepository adminRepository;

	public AdminController(AdminService adminService, AdminRepository adminRepository) {
		this.adminService = adminService;
		this.adminRepository = adminRepository;
	}

	@PostMapping("/view")
	public ResponseEntity<?> getAdmin(@RequestBody Admin id) {
		int id1 = id.getId();
		Admin admin = adminService.getAdminById(id1);
		if (admin != null) {
			return ResponseEntity.ok(admin);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin not found");
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginAdmin(@RequestBody Admin adminData) {
		Admin admin = adminRepository.findByEmail(adminData.getEmail());
		if (admin != null && admin.getPassword().equals(adminData.getPassword())) {
			return ResponseEntity.ok(admin);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
		}
	}

	@PostMapping("/insert")
	public ResponseEntity<String> saveAdmin(@RequestBody Admin admin) {
		try {
			adminService.saveAdmin(admin);
			return ResponseEntity.status(HttpStatus.CREATED).body("Created Successfully");
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create admin: Email already exists.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to create admin: " + e.getMessage());
		}
	}

}
