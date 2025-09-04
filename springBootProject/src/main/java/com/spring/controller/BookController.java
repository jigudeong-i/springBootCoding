package com.spring.controller;

import com.spring.main.Book;
import com.spring.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("book")
public class BookController {

    private BookService service;

    @GetMapping("selectAllList")
    public List<Book> selectAllList() {
        return service.selectAllList();
    }
}