package com.boot.example.service;

import com.boot.example.domain.Book;

import java.util.List;

public interface BookService {
    public List<Book> bookList();
    public int bookInsert(Book book);
}
