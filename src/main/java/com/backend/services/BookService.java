package com.backend.services;

import com.backend.models.Book;
import com.backend.models.BookAssignment;
import com.backend.models.Student;
import com.backend.repositories.BookAssignmentRepository;
import com.backend.repositories.BookRepository;
import com.backend.repositories.StudentRepository;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Setter
@Getter
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private StudentRepository studentRepository;

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
    	System.out.println("In the asssignement repo" + id);
        bookAssignmentRepository.deleteById(id);
    }
    
    public void assignBookToStudent(int studentId, int bookId) {
        // Retrieve student and book by their IDs
    	System.out.println("The id is ");
    	System.out.println(studentId);
    	System.out.println("The bookid is ");
    	System.out.println(bookId);
    	int id = Integer.parseInt(String.valueOf(bookId));
        Student student = studentRepository.findById(studentId).orElse(null);
        System.out.println("student okk");
        System.out.println(student);
        Book book = bookRepository.findById(id).orElse(null);
        System.out.println("book okk");
        System.out.println(book);
        System.out.println("book okk");
        System.out.println(book);

        // Check if both student and book exist
        if (student != null && book != null) {
            // Create a new book assignment
            BookAssignment bookAssignment = new BookAssignment();
            System.out.println("In the assign services " + bookAssignment);
            bookAssignment.setStudent(student);
            bookAssignment.setBook(book);

            // Save the book assignment
            bookAssignmentRepository.save(bookAssignment);
        } else {
            // Handle case where student or book is not found
            throw new RuntimeException("Student or book not found");
        }
    }
}
