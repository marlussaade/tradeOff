package br.com.mrsitech.tradeOff.application.services;

import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffResponseDTO;
import br.com.mrsitech.tradeOff.adapters.outbound.ExternalBrasilApiDdd;
import br.com.mrsitech.tradeOff.application.mappers.BrasilApiDddRequestMapping;
import br.com.mrsitech.tradeOff.application.mappers.TradeOffRespondMapping;
import br.com.mrsitech.tradeOff.application.mappers.dto.BrasilApiGetDddResponseDTO;
import br.com.mrsitech.tradeOff.application.port.CalculationAndFindDddInterface;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import br.com.mrsitech.tradeOff.application.services.MockCalculationAndFindDddServiceTest;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculationAndFindDddServiceTest {

    @InjectMocks
    CalculationAndFindDddService calculationAndFindDddService;

    @Mock
    BrasilApiDddRequestMapping brasilApiDddMapping;

    @Mock
    ExternalBrasilApiDdd externalBrasilApiDdd;

    @Mock
    TradeOffRespondMapping tradeOffRespondMapping;

    @Test
    public void postCalculationAndFindDdd(){
        when(brasilApiDddMapping.brasilApiMappingToGetDdd(any())).thenReturn(MockCalculationAndFindDddServiceTest.mockDdd());
        when(externalBrasilApiDdd.getDddBrasilApi(any())).thenReturn(MockCalculationAndFindDddServiceTest.mockApiBrasilResponseDdd());
        when(tradeOffRespondMapping.tradeOffRespondMapping(any(),any())).thenReturn(MockCalculationAndFindDddServiceTest.resultPostCalculationAndFindDddExpetation());


    var resultPostCalculationAndFindDdd =  calculationAndFindDddService.postCalculationAndFindDdd(MockCalculationAndFindDddServiceTest.mockNumberPhone(),MockCalculationAndFindDddServiceTest.mockTradeOffBodyRequestDTO());

    assertEquals(MockCalculationAndFindDddServiceTest.resultPostCalculationAndFindDddExpetation(), resultPostCalculationAndFindDdd);
    }
}
