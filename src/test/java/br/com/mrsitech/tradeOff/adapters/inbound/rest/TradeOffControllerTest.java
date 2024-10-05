package br.com.mrsitech.tradeOff.adapters.inbound.rest;

import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffBodyRequestDTO;
import br.com.mrsitech.tradeOff.application.port.CalculationAndFindDddInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@WebMvcTest(TradeOffController.class)
public class TradeOffControllerTest {



    @Autowired
    MockMvc mockMvc;
    @MockBean
    CalculationAndFindDddInterface calculationAndFindDddInterface;


    @Test
    public void shouldReturnOkStatusForPostTradeOff() throws Exception {
        when(calculationAndFindDddInterface.postCalculationAndFindDdd(any(),any())).thenReturn(MockTradeOffControllerTest.mockOfTradeOffResponseDTO());

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/proteinTradeOff/{phoneNumber}","41996447054")
                        .contentType("application/json")
                        .content(MockTradeOffControllerTest.mockOfShouldReturnOkStatusForPostTradeOff()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
