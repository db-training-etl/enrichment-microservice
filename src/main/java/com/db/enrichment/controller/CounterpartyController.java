package com.db.enrichment.controller;

import com.db.enrichment.entity.Counterparty;
import com.db.enrichment.serivce.CounterpartyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/counterparties")
    public ResponseEntity<Counterparty> createCounterparty(@RequestBody Counterparty counterparty) throws Exception {
        return new ResponseEntity<>(counterpartyService.save(counterparty), org.springframework.http.HttpStatus.CREATED);
    }

}
