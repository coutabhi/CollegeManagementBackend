package com.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "staff")
@Data
public class Staff {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;

	String firstname;
	String lastname;
	String gender;
	String designation;
	String mobileno;
	String email;
	String password;
}
