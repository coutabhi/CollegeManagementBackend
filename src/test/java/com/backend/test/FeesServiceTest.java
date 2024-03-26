package com.backend.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.backend.models.Fees;
import com.backend.repositories.FeesRepository;
import com.backend.services.FeesService;

public class FeesServiceTest {

    @Mock
    private FeesRepository feesRepository;

    @InjectMocks
    private FeesService feesService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllLogin() {
        List<Fees> feesList = new ArrayList<>();
        feesList.add(new Fees());
        feesList.add(new Fees());

        when(feesRepository.findAll()).thenReturn(feesList);

        List<Fees> result = feesService.getAllLogin();

        assertEquals(2, result.size());
    }

    @Test
    public void testSaveStudent() {
        Fees fees = new Fees();

        feesService.saveStudent(fees);

        verify(feesRepository).save(fees);
    }
    
}