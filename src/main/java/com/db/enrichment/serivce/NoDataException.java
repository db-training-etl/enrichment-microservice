package com.db.enrichment.serivce;

import org.springframework.stereotype.Service;

@Service
public class NoDataException {

    public String sendException() {
        return "No data found";
    }
}
