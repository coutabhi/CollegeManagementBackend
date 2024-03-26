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

import com.backend.models.Student;
import com.backend.repositories.StudentRepository;
import com.backend.services.StudentService;

public class StudentServiceTest {

	@Mock
	private StudentRepository studentRepository;

	@InjectMocks
	private StudentService studentService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetAllLogin() {
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student());
		studentList.add(new Student());

		when(studentRepository.findAll()).thenReturn(studentList);

		List<Student> result = studentService.getAllLogin();

		assertEquals(2, result.size());
	}

	@Test
	public void testSaveStudent() {
		Student student = new Student();

		studentService.saveStudent(student);

		verify(studentRepository).save(student);
	}

	@Test
	public void testUpdateStudent() {
		Student student = new Student();

		studentService.updateStudent(student);

		verify(studentRepository).save(student);
	}

	@Test
	public void testDeleteStudent() {
		Student student = new Student();

		studentService.deleteStudent(student);

		verify(studentRepository).delete(student);
	}

	@Test
	public void testGetStudentById() {
		int id = 1;
		Student student = new Student();
		student.setId(id);
		Optional<Student> optional = Optional.of(student);

		when(studentRepository.findById(id)).thenReturn(optional);

		Student result = studentService.getStudentById(id);

		assertEquals(id, result.getId());
	}

	@Test
	public void testSaveUser() {
		Student student = new Student();

		studentService.saveUser(student);

		verify(studentRepository).save(student);
	}
}