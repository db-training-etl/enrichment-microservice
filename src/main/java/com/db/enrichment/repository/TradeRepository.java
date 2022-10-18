package com.db.enrichment.repository;

import com.db.enrichment.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade,Integer> {

}

