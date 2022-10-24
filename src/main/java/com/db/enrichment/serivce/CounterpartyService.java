package com.db.enrichment.serivce;


import com.db.enrichment.entity.Counterparty;
import org.springframework.stereotype.Service;

@Service
public class CounterpartyService {

        public Counterparty getCounterparty(Integer counterpartyId) {
            return new Counterparty();
        }

}
