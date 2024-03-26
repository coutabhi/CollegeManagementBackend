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

import com.backend.models.CEFaculty;
import com.backend.repositories.CEFacultyRepository;
import com.backend.services.CEFacultyService;

public class CEFacultyServiceTest {

    @Mock
    private CEFacultyRepository ceFacultyRepo;

    @InjectMocks
    private CEFacultyService ceFacultyService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllLogin() {
        List<CEFaculty> facultyList = new ArrayList<>();
        facultyList.add(new CEFaculty());
        facultyList.add(new CEFaculty());

        when(ceFacultyRepo.findAll()).thenReturn(facultyList);

        List<CEFaculty> result = ceFacultyService.getAllLogin();

        assertEquals(2, result.size());
    }

    @Test
    public void testSaveStudent() {
        CEFaculty faculty = new CEFaculty();

        ceFacultyService.saveStudent(faculty);

        verify(ceFacultyRepo).save(faculty);
    }

    @Test
    public void testUpdateStudent() {
        CEFaculty faculty = new CEFaculty();

        ceFacultyService.updateStudent(faculty);

        verify(ceFacultyRepo).save(faculty);
    }

    @Test
    public void testDeleteStudent() {
        CEFaculty faculty = new CEFaculty();

        ceFacultyService.deleteStudent(faculty);

        verify(ceFacultyRepo).delete(faculty);
    }

    @Test
    public void testGetStudentById() {
        int id = 1;
        CEFaculty faculty = new CEFaculty();
        faculty.setId(id);
        Optional<CEFaculty> optional = Optional.of(faculty);

        when(ceFacultyRepo.findById(id)).thenReturn(optional);

        CEFaculty result = ceFacultyService.getStudentById(id);

        assertEquals(id, result.getId());
    }

    @Test
    public void testSaveUser() {
        CEFaculty faculty = new CEFaculty();

        ceFacultyService.saveUser(faculty);

        verify(ceFacultyRepo).save(faculty);
    }
}