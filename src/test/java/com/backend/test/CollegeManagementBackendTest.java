package com.backend.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import com.backend.services.AdminService;

@SpringBootTest
@AutoConfigureMockMvc
public class CollegeManagementBackendTest {


    @Autowired
    private AdminService adminService;

    @Test
    public void testGetAllAdmins() throws Exception {
    	adminService.getAllAdmins();
    	System.out.println("getting all admins");
    }
}

