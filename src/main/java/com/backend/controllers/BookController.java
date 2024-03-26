package com.backend.controllers;

import com.backend.models.Book;
import com.backend.models.BookAssignment;
import com.backend.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//http://localhost:4200/api/v1/books
@RestController
@RequestMapping("/api/v1/books")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Optional<Book> book = bookService.getBookById(id);
        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        Book savedBook = bookService.saveBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book bookDetails) {
        Optional<Book> optionalBook = bookService.getBookById(id);
        
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            existingBook.setTitle(bookDetails.getTitle());
            existingBook.setAuthor(bookDetails.getAuthor());
            // Update other fields as needed
            
            Book updatedBook = bookService.saveBook(existingBook);
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/assignments")
    public ResponseEntity<List<BookAssignment>> getAllBookAssignments() {
        List<BookAssignment> bookAssignments = bookService.getAllBookAssignments();
        return new ResponseEntity<>(bookAssignments, HttpStatus.OK);
    }

    @GetMapping("/assignments/{id}")
    public ResponseEntity<BookAssignment> getBookAssignmentById(@PathVariable int id) {
        Optional<BookAssignment> bookAssignment = bookService.getBookAssignmentById(id);
        return bookAssignment.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/assignments")
    public ResponseEntity<BookAssignment> saveBookAssignment(@RequestBody BookAssignment bookAssignment) {
        BookAssignment savedBookAssignment = bookService.saveBookAssignment(bookAssignment);
        return new ResponseEntity<>(savedBookAssignment, HttpStatus.CREATED);
    }

    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<Void> deleteBookAssignment(@PathVariable int id) {
        bookService.deleteBookAssignment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PostMapping("/assignments/assign/{studentId}/{bookId}")
    public ResponseEntity<Void> assignBookToStudent(@PathVariable int studentId, @PathVariable int bookId) {
        bookService.assignBookToStudent(studentId, bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
