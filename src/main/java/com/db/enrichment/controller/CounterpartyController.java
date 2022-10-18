package com.db.enrichment.controller;

import com.db.enrichment.entity.Counterparty;
import com.db.enrichment.serivce.CounterpartyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterpartyController {

    private CounterpartyService counterpartyService;

    public CounterpartyController(CounterpartyService counterpartyService) {
        this.counterpartyService = counterpartyService;
    }

    @GetMapping("/counterparties")
   public Iterable<Counterparty> list() {
        return counterpartyService.list();
    }

}
