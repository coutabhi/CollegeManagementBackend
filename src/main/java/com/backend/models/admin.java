package com.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	String firstname;
	String lastname;
	String email;
	String password;
}
