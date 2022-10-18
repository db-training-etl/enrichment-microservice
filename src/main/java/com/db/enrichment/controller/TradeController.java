package com.db.enrichment.controller;

import com.db.enrichment.entity.Trade;
import com.db.enrichment.serivce.TradeService;
import org.springframework.web.bind.annotation.GetMapping;

public class TradeController {

    private TradeService tradeService;

   public TradeController(TradeService tradeService) {
            this.tradeService = tradeService;
    }

    @GetMapping("/trade")
    public Iterable<Trade> list() {
       return tradeService.list();
    }
}


