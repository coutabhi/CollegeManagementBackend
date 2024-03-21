package com.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CollegeManagementBackendApplication {

	public static void main(String[] args) {
		System.out.println("Code comes inside main");
		SpringApplication.run(CollegeManagementBackendApplication.class, args);
	}

}
