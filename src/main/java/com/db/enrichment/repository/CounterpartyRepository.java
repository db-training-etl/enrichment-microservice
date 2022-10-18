package com.db.enrichment.repository;

import com.db.enrichment.entity.Counterparty;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CounterpartyRepository extends JpaRepository<Counterparty,Integer> {

}