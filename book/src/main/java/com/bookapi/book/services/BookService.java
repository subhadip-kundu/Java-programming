package com.bookapi.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.bookapi.book.Entities.Book;

@Component
public class BookService {
    private static List<Book> list = new ArrayList<>();
    static {
        list.add(new Book(101, "Python", "Mark"));
        list.add(new Book(102, "C++", "Yan"));
        list.add(new Book(103, "JavaScript", "Jain"));
        list.add(new Book(104, "Ruby", "Monalisha"));
        list.add(new Book(105, "C#", "Rahul"));
    }

    // Get all books
    public List<Book> getAllBooks() {
        return list;
    }

    // Get single book
    public Book getBookById(int id) {
        try {
            Book book = null;
            book = list.stream().filter(b -> b.getId() == id).findFirst().get();
            return book;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Adding the book
    public Book addBook(Book b) {
        list.add(b);
        return b;
    }

    // Delete Book

    public List<Book> deleteBook(int id) {
        list = list.stream()
                .filter(book -> book.getId() != id)
                .collect(Collectors.toList());

        return list;
    }

    // Update book

    public void updateBook(Book book, int id) {
       list = list.stream().map(b -> {
            if (b.getId() == id) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
