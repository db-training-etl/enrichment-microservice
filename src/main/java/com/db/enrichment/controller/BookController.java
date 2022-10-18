package com.db.enrichment.controller;

import com.db.enrichment.entity.Book;
import com.db.enrichment.serivce.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public Iterable<Book> list() {
        return bookService.list();
    }
}
