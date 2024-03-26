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

import com.backend.models.EEFaculty;
import com.backend.repositories.EEFacultyRepository;
import com.backend.services.EEFacultyService;

public class EEFacultyServiceTest {

	@Mock
	private EEFacultyRepository eeFacultyRepo;

	@InjectMocks
	private EEFacultyService eeFacultyService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetAllLogin() {
		List<EEFaculty> facultyList = new ArrayList<>();
		facultyList.add(new EEFaculty());
		facultyList.add(new EEFaculty());

		when(eeFacultyRepo.findAll()).thenReturn(facultyList);

		List<EEFaculty> result = eeFacultyService.getAllLogin();

		assertEquals(2, result.size());
	}

	@Test
	public void testSaveStudent() {
		EEFaculty faculty = new EEFaculty();

		eeFacultyService.saveStudent(faculty);

		verify(eeFacultyRepo).save(faculty);
	}

	@Test
	public void testUpdateStudent() {
		EEFaculty faculty = new EEFaculty();

		eeFacultyService.updateStudent(faculty);

		verify(eeFacultyRepo).save(faculty);
	}

	@Test
	public void testDeleteStudent() {
		EEFaculty faculty = new EEFaculty();

		eeFacultyService.deleteStudent(faculty);

		verify(eeFacultyRepo).delete(faculty);
	}

	@Test
	public void testGetStudentById() {
		int id = 1;
		EEFaculty faculty = new EEFaculty();
		faculty.setId(id);
		Optional<EEFaculty> optional = Optional.of(faculty);

		when(eeFacultyRepo.findById(id)).thenReturn(optional);

		EEFaculty result = eeFacultyService.getStudentById(id);

		assertEquals(id, result.getId());
	}

	@Test
	public void testSaveUser() {
		EEFaculty faculty = new EEFaculty();

		eeFacultyService.saveUser(faculty);

		verify(eeFacultyRepo).save(faculty);
	}
}