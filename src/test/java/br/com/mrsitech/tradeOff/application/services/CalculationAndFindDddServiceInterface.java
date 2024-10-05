package br.com.mrsitech.tradeOff.application.services;

import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffBodyRequestDTO;
import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffResponseDTO;

public interface CalculationAndFindDddServiceInterface {
    TradeOffResponseDTO postCalculationAndFindDdd(String phoneNumber, TradeOffBodyRequestDTO tradeOffBodyRequest);

}
