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
    private NoDataException noDataException;

    public TradeService(CounterpartyService counterpartyService, BookService bookService, NoDataException noDataException) {
        this.counterpartyService = counterpartyService;
        this.bookService = bookService;
        this.noDataException = noDataException;



        }

        public Trade enrich(Trade trade) throws Exception {
            trade.setCounterparty(counterpartyService.getCounterparty(trade.getCounterpartyId()));
            trade.setBook(bookService.getBook(trade.getBookId()));
            return trade;
        }

        public String getCounterparty(String counterpartyId) throws Exception {
            WebClient webClient = WebClient.create();
            String url = "http://localhost:8081/counterparty/" + counterpartyId;
            return webClient.get()
                    .uri(url)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        }

        public String getBook(String bookId) throws Exception {
            WebClient webClient = WebClient.create();
            String url = "http://localhost:8081/book/" + bookId;
            return webClient.get()
                    .uri(url)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        }

        public String getNoData() throws Exception {
            return noDataException.sendException();
        }

        public String getTrade(String id) throws Exception {
            return "Trade id is " + id;
        }

}
