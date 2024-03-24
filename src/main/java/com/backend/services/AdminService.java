package com.backend.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.backend.models.Admin;
import com.backend.repositories.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRep;

	public AdminService() {
	}

	public List<Admin> getAllAdmins() {
		return adminRep.findAll();
	}

	public void saveAdmin(Admin admin) {
        try {
            adminRep.save(admin);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Email already exists.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to save admin: " + e.getMessage());
        }
    }

	public Admin getAdminById(int id) {
		Optional<Admin> pm = adminRep.findById(id);
		if (pm.isPresent()) {
			return pm.get();
		} else
			return null;
	}

	public void saveAdmin1(Admin ll) {
		adminRep.save(ll);
	}
	
	public void deleteAdmin(Admin id) {
		adminRep.delete(id);
	}
	
	public void updateAdmin(Admin ll1) {
		adminRep.save(ll1);
	}

}
