package com.db.enrichment.test;


import com.db.enrichment.config.BookEnrichment;
import org.junit.jupiter.api.BeforeEach;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@RunWith(SpringRunner.class)

public class TradeEnrichmentTest {

    @Autowired
    private MockMvc mockMvc;
    private BookEnrichment bookEnrichment;

    @BeforeEach
    public void setup() {
        bookEnrichment = new BookEnrichment();
    }

    @Test
    public void testEnrichment() {
        bookEnrichment.enrich();
    }

    @Test
    public void PostTrade() throws Exception {
        //GIVEN
        ResultActions resultActions = mockMvc.perform(post("/trades/enrich"));
        //WHEN
        MvcResult mvcResult = resultActions.andDo(print()).andExpect(status().isOk()).andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        //THEN
        assertEquals("Trade", contentAsString);
    }

    @Test
    public void GivenTrade_WhenEnrichment_ThenBookIsEnriched() throws Exception {
        //GIVEN
        ResultActions request = mockMvc.perform(post("/trade/1"));
        //WHEN
        MvcResult mvcResult = request.andDo(print()).andExpect(status().isOk()).andReturn();
        //THEN
        assertEquals("1", mvcResult.getResponse().getContentType());
    }

    @Test
    public void GivenTrade_WhenEnrichment_ThenCounterpartyIsEnriched() throws Exception {
        //GIVEN
        ResultActions request = mockMvc.perform(get("/counterparty/1"));
        //WHEN
        MvcResult mvcResult = request.andDo(print()).andExpect(status().isOk()).andReturn();
        //THEN
        assertEquals("1", mvcResult.getResponse().getContentType());
    }

    @Test
    public void GivenTrade_WhenEnrichment_ThenTradeIsEnriched() throws Exception {
        //GIVEN
        ResultActions request = mockMvc.perform(get("/trade/1"));
        //WHEN
        MvcResult mvcResult = request.andDo(print()).andExpect(status().isOk()).andReturn();
        //THEN
        assertEquals("1", mvcResult.getResponse().getContentType());
    }

    @Test
    public void GivenTrade_WhenEnrichment_ThenNoDataIsEnriched() throws Exception {
        //GIVEN
        ResultActions request = mockMvc.perform(get("/trade/1"));
        //WHEN
        MvcResult mvcResult = request.andDo(print()).andExpect(status().isOk()).andReturn();
        //THEN
        assertEquals("1", mvcResult.getResponse().getContentType());
    }



}




