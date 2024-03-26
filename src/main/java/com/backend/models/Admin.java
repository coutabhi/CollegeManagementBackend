package com.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	String firstname;
	
	@Column(nullable = false)
	String lastname;
	
	@Column(unique = true, nullable = false)
	String email;
	
	@Column(nullable = false)
	String password;
}
