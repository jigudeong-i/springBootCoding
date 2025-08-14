package com.boot.example.controller;

import com.boot.example.domain.Book;
import com.boot.example.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/bookList")
    public String bookList(Model model) {
        List<Book> bookList = bookService.bookList();
        model.addAttribute("bookList", bookList);
        return "/book/bookList";
    }
}
