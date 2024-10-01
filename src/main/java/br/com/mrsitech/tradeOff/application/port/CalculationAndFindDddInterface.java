package br.com.mrsitech.tradeOff.application.port;

import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffResponseDTO;
import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffBodyRequestDTO;

public interface CalculationAndFindDddInterface {
    TradeOffResponseDTO postCalculationAndFindDdd(String phoneNumber, TradeOffBodyRequestDTO tradeOffBodyRequest);
}
