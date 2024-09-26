package br.com.mrsitech.tradeOff.adapters.inbound.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(TradeOffController.class)
public class TradeOffControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldReturnOkStatusForPostTradeOff() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/tradeOff"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(
                        MockTradeOffControllerTest.mockOfShouldReturnOkStatusForPostTradeOff()
                ));
    }

    @Test
    public void shouldReturnOkStatusForGetTradeOff() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tradeOff/idByPhoneNumber"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        MockTradeOffControllerTest.mockOffShouldReturnOkStatusForGetTradeOff()
                ));
    }
}
