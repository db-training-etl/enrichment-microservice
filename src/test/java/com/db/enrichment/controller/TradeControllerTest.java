package com.db.enrichment.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@AutoConfigureMockMvc
@SpringBootTest
@RunWith(SpringRunner.class)
class TradeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void Given_Post_Trade() throws Exception {
        //GIVEN
        ResultActions resultActions = mockMvc.perform(post("/trades/enrich").contentType("application/json").content("""
                {
                  "id": 1,
                  "tradeName": "hola",
                  "bookId": 1,
                  "country": "CA",
                  "counterpartyId": 2,
                  "currency": "USD",
                  "cobDate": "2022-10-10",
                  "amount": 10.0,
                  "tradeTax": false
                }""".indent(2)));
        //WHEN
        MvcResult mvcResult = resultActions.andDo(print()).andExpect(status().isOk()).andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        //THEN
        assertEquals("{\"id\":1,\"tradeName\":\"hola\",\"bookId\":1,\"country\":\"CA\",\"counterpartyId\":2,\"currency\":\"USD\",\"cobDate\":\"2022-10-10T00:00:00.000+00:00\",\"amount\":10.0,\"tradeTax\":false,\"book\":{\"bookId\":null,\"bookName\":null,\"bookAddress\":null,\"entity\":null},\"counterparty\":{\"counterpartyId\":null,\"counterpartyName\":null,\"source\":null,\"entity\":null}}", contentAsString);
    }
}