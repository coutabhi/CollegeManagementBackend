package com.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "book")
@Data
public class Book {
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;

    @Column(nullable = false)
    String title;
    
    @Column(nullable = false)
    String author;
    
    @Column(nullable = false)
    String genre;
    
    @Column(nullable = false)
    String isbn;

    @OneToOne(mappedBy = "book")
    BookAssignment bookAssignment;
}
