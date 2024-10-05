package br.com.mrsitech.tradeOff.application.port;

import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffResponseDTO;
import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffBodyRequestDTO;
import br.com.mrsitech.tradeOff.application.mappers.dto.BrasilApiGetDddResponseDTO;

public interface CalculationAndFindDddInterface {
    TradeOffResponseDTO postCalculationAndFindDdd(String phoneNumber, TradeOffBodyRequestDTO tradeOffBodyRequest);
}
