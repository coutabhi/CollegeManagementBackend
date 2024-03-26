package com.backend.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.backend.models.MEFaculty;
import com.backend.repositories.MEFacultyRepository;
import com.backend.services.MEFacultyService;

public class MEFacultyServiceTest {

	@Mock
	private MEFacultyRepository meFacultyRepo;

	@InjectMocks
	private MEFacultyService meFacultyService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetAllLogin() {
		List<MEFaculty> facultyList = new ArrayList<>();
		facultyList.add(new MEFaculty());
		facultyList.add(new MEFaculty());

		when(meFacultyRepo.findAll()).thenReturn(facultyList);

		List<MEFaculty> result = meFacultyService.getAllLogin();

		assertEquals(2, result.size());
	}

	@Test
	public void testSaveStudent() {
		MEFaculty faculty = new MEFaculty();

		meFacultyService.saveStudent(faculty);

		verify(meFacultyRepo).save(faculty);
	}

	@Test
	public void testUpdateStudent() {
		MEFaculty faculty = new MEFaculty();

		meFacultyService.updateStudent(faculty);

		verify(meFacultyRepo).save(faculty);
	}

	@Test
	public void testDeleteStudent() {
		MEFaculty faculty = new MEFaculty();

		meFacultyService.deleteStudent(faculty);

		verify(meFacultyRepo).delete(faculty);
	}

	@Test
	public void testGetStudentById() {
		int id = 1;
		MEFaculty faculty = new MEFaculty();
		faculty.setId(id);
		Optional<MEFaculty> optional = Optional.of(faculty);

		when(meFacultyRepo.findById(id)).thenReturn(optional);

		MEFaculty result = meFacultyService.getStudentById(id);

		assertEquals(id, result.getId());
	}

	@Test
	public void testSaveUser() {
		MEFaculty faculty = new MEFaculty();

		meFacultyService.saveUser(faculty);

		verify(meFacultyRepo).save(faculty);
	}
}