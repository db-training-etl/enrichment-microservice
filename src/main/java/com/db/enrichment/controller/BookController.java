package com.db.enrichment.controller;

import com.db.enrichment.entity.Book;
import com.db.enrichment.serivce.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/book")
    public ResponseEntity<Book> createBook(@RequestBody Book book) throws Exception {
        return new ResponseEntity<>(bookService.save(book), org.springframework.http.HttpStatus.CREATED);
    }

}
