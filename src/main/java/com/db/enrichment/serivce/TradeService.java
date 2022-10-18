package com.db.enrichment.serivce;

import com.db.enrichment.entity.Trade;
import com.db.enrichment.repository.TradeRepository;
import org.springframework.stereotype.Service;

@Service
public class TradeService {

    TradeRepository tradeRepository;

    public TradeService(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    public Iterable<Trade> list() {
        return tradeRepository.findAll();
    }

    public Trade save(Trade trade) {
        return tradeRepository.save(trade);
    }

    public Iterable<Trade> saveAll(Iterable<Trade> trades) {
        return tradeRepository.saveAll(trades);
    }
}
