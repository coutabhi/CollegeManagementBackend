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
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book_assignment")
@Setter
@Getter
public class BookAssignment {
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    int bid;

    @ManyToOne
    @JoinColumn(name = "studentId")
    Student student;

    @OneToOne
    @JoinColumn(name = "id")
    Book book;
}
