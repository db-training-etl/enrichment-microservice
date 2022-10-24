package com.db.enrichment.controller;

import com.db.enrichment.entity.Trade;
import com.db.enrichment.serivce.TradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeController {

    private TradeService tradeService;

   public TradeController(TradeService tradeService) {
            this.tradeService = tradeService;
    }



    @PostMapping("/trades/enrich")
    public ResponseEntity<Trade> enrichTrade(@Validated @RequestBody Trade trade) throws Exception {
        System.out.printf("Trade id is %s", trade.getId());
        return ResponseEntity.ok(tradeService.enrich(trade));
    }

}


