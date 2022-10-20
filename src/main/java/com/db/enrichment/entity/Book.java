package com.db.enrichment.entity;

import lombok.Data;

@Data
public class Book {
    Integer bookId;
    String bookName;
    String bookAddress;
    String entity;

    public Book getBook(Integer bookId) {
        return null;
    }

}
