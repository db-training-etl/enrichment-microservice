package com.db.enrichment.entity;

import lombok.Data;

@Data

public class Counterparty {
    Integer counterpartyId;
    String counterpartyName;
    String source;
    String entity;

public class Counterparty {
    Integer bookId;
    String bookName;
    String bookAddress;
    String entity;
}