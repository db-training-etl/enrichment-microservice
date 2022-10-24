package com.db.enrichment.serivce;

import com.db.enrichment.entity.Book;
import com.db.enrichment.entity.Counterparty;
import com.db.enrichment.entity.Trade;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TradeService {

    private CounterpartyService counterpartyService;
    private BookService bookService;

    public TradeService(CounterpartyService counterpartyService, BookService bookService) {
        this.counterpartyService = counterpartyService;
        this.bookService = bookService;
        }

        public Trade enrich(Trade trade) throws Exception {
            trade.setCounterparty(counterpartyService.getCounterparty(trade.getCounterpartyId()));
            trade.setBook(bookService.getBook(trade.getBookId()));
            return trade;
        }

}
