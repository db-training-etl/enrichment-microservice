package com.db.enrichment.serivce;


import com.db.enrichment.entity.Counterparty;
import com.db.enrichment.repository.CounterpartyRepository;
import org.springframework.stereotype.Service;

@Service
public class CounterpartyService {

    CounterpartyRepository counterpartyRepository;

    public CounterpartyService(CounterpartyRepository counterpartyRepository) {
        this.counterpartyRepository = counterpartyRepository;
    }

    public Iterable<Counterparty> list() {
        return counterpartyRepository.findAll();
    }

    public Counterparty save(Counterparty counterparty) {
        return counterpartyRepository.save(counterparty);
    }

    public Iterable<Counterparty> saveAll(Iterable<Counterparty> counterparties) {
        return counterpartyRepository.saveAll(counterparties);
    }


}
