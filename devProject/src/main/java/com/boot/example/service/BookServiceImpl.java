package com.boot.example.service;

import com.boot.example.domain.Book;
import com.boot.example.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookMapper bookMapper;   //BookMapper 에 접근할 수 있는 참조변수 선언

    @Override
    public List<Book> bookList(){
        return bookMapper.bookList();
    }

    @Override
    public int bookInsert(Book book){
        int result = bookMapper.bookInsert(book);
        return result;
    }
}
