package com.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="branch")
@Data
public class Branch {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String branch;
}
