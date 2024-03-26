package com.backend.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.backend.models.Admin;
import com.backend.repositories.AdminRepository;
import com.backend.services.AdminService;

public class AdminServiceTest {

	@Mock
	private AdminRepository adminRepository;

	@InjectMocks
	private AdminService adminService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetAllAdmins() {
		List<Admin> adminList = new ArrayList<>();
		adminList.add(new Admin());
		adminList.add(new Admin());

		when(adminRepository.findAll()).thenReturn(adminList);

		List<Admin> result = adminService.getAllAdmins();

		assertEquals(2, result.size());
	}

	@Test
	public void testSaveAdmin() {
		Admin admin = new Admin();

		adminService.saveAdmin(admin);

		verify(adminRepository).save(admin);
	}

	@Test
	public void testUpdateAdmin() {
		Admin admin = new Admin();

		adminService.updateAdmin(admin);

		verify(adminRepository).save(admin);
	}

	@Test
	public void testDeleteAdmin() {
		Admin admin = new Admin();

		adminService.deleteAdmin(admin);

		verify(adminRepository).delete(admin);
	}

	@Test
	public void testGetAdminById() {
		int id = 1;
		Admin admin = new Admin();
		admin.setId(id);
		Optional<Admin> optional = Optional.of(admin);

		when(adminRepository.findById(id)).thenReturn(optional);

		Admin result = adminService.getAdminById(id);

		assertEquals(id, result.getId());
	}

	// Add your additional test methods as needed
}