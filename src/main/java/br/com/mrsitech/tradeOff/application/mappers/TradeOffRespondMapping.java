package br.com.mrsitech.tradeOff.application.mappers;

import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffBodyRequestDTO;
import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffResponseDTO;
import br.com.mrsitech.tradeOff.application.mappers.dto.BrasilApiGetDddResponseDTO;

public interface TradeOffRespondMapping {

    TradeOffResponseDTO tradeOffRespondMapping(BrasilApiGetDddResponseDTO brasilApiGetDddResponseDTO, TradeOffBodyRequestDTO tradeOffBodyRequestDTO);
}
