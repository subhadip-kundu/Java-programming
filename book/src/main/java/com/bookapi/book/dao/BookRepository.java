package com.bookapi.book.dao;

import org.springframework.data.repository.CrudRepository;

import com.bookapi.book.Entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
    public Book findById(int id);
}
