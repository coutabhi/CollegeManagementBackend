package com.backend.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.backend.models.Book;
import com.backend.models.BookAssignment;
import com.backend.repositories.BookAssignmentRepository;
import com.backend.repositories.BookRepository;
import com.backend.services.BookService;

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookAssignmentRepository bookAssignmentRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllBooks() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book());
        bookList.add(new Book());

        when(bookRepository.findAll()).thenReturn(bookList);

        List<Book> result = bookService.getAllBooks();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetBookById() {
        int id = 1;
        Book book = new Book();
        book.setId(id);
        Optional<Book> optional = Optional.of(book);

        when(bookRepository.findById(id)).thenReturn(optional);

        Optional<Book> result = bookService.getBookById(id);

        assertEquals(id, result.get().getId());
    }

    @Test
    public void testSaveBook() {
        Book book = new Book();

        bookService.saveBook(book);

        verify(bookRepository).save(book);
    }

    @Test
    public void testDeleteBook() {
        int id = 1;

        bookService.deleteBook(id);

        verify(bookRepository).deleteById(id);
    }

    @Test
    public void testGetAllBookAssignments() {
        List<BookAssignment> assignmentList = new ArrayList<>();
        assignmentList.add(new BookAssignment());
        assignmentList.add(new BookAssignment());

        when(bookAssignmentRepository.findAll()).thenReturn(assignmentList);

        List<BookAssignment> result = bookService.getAllBookAssignments();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetBookAssignmentById() {
        int id = 1;
        BookAssignment assignment = new BookAssignment();
        assignment.setBid(id);
        Optional<BookAssignment> optional = Optional.of(assignment);

        when(bookAssignmentRepository.findById(id)).thenReturn(optional);

        Optional<BookAssignment> result = bookService.getBookAssignmentById(id);

        assertEquals(id, result.get().getBid());
    }

    @Test
    public void testSaveBookAssignment() {
        BookAssignment assignment = new BookAssignment();

        bookService.saveBookAssignment(assignment);

        verify(bookAssignmentRepository).save(assignment);
    }

    @Test
    public void testDeleteBookAssignment() {
        int id = 1;

        bookService.deleteBookAssignment(id);

        verify(bookAssignmentRepository).deleteById(id);
    }
}