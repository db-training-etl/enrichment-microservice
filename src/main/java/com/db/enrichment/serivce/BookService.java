package com.db.enrichment.serivce;

import com.db.enrichment.entity.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    public Book getBook(Integer bookId) {
        return new Book();
    }

}
