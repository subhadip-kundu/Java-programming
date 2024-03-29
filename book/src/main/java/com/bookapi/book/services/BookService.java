package com.bookapi.book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookapi.book.Entities.Book;
import com.bookapi.book.dao.BookRepository;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Get all books
    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    // Get single book
    public Book getBookById(int id) {
        try {
            Book book = this.bookRepository.findById(id);
            return book;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Adding the book
    public Book addBook(Book b) {
        Book result = bookRepository.save(b);
        return result;
    }

    // Delete Book

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    // Update book

    public void updateBook(Book book, int id) {

        book.setId(id);

        bookRepository.save(book);
    }
}
