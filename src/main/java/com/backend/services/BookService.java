package com.backend.services;

import com.backend.models.Book;
import com.backend.models.BookAssignment;
import com.backend.repositories.BookAssignmentRepository;
import com.backend.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookAssignmentRepository bookAssignmentRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public List<BookAssignment> getAllBookAssignments() {
        return bookAssignmentRepository.findAll();
    }

    public Optional<BookAssignment> getBookAssignmentById(int id) {
        return bookAssignmentRepository.findById(id);
    }

    public BookAssignment saveBookAssignment(BookAssignment bookAssignment) {
        return bookAssignmentRepository.save(bookAssignment);
    }

    public void deleteBookAssignment(int id) {
        bookAssignmentRepository.deleteById(id);
    }
}
