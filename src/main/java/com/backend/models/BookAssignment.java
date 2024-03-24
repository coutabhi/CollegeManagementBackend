package com.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "book_assignment")
@Data
public class BookAssignment {
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;

    @OneToOne
    @JoinColumn(name = "book_id")
    Book book;
}
