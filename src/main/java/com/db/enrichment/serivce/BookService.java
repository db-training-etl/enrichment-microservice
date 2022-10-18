package com.db.enrichment.serivce;

import com.db.enrichment.entity.Book;
import com.db.enrichment.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> list() {
        return bookRepository.findAll();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Iterable<Book> saveAll(Iterable<Book> books) {
        return bookRepository.saveAll(books);
    }


}
