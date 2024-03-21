package com.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="marksheet")
@Data
public class Marksheet {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;

	String firstname;
	String lastname;
	String mI;
	String physics;
	String chemistry;
	String enggdraw;
	String totalmarks;
}
