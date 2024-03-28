package com.bookapi.book.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bookapi.book.Entities.Book;
import com.bookapi.book.services.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // Get all book handler
    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.bookService.getAllBooks();
    }

    // Get single book handler
    @GetMapping("/book/{id}")
    public Book getBooksById(@PathVariable int id) {
        return this.bookService.getBookById(id);
    }

    // Add new book handler
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        Book b = this.bookService.addBook(book);
        return b;
    }



    

}
