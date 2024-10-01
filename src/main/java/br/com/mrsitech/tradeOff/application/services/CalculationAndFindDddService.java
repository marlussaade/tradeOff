package br.com.mrsitech.tradeOff.application.services;

import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffResponseDTO;
import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffBodyRequestDTO;
import br.com.mrsitech.tradeOff.application.port.CalculationAndFindDddInterface;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class CalculationAndFindDddService implements CalculationAndFindDddInterface {
    @Override
    public TradeOffResponseDTO postCalculationAndFindDdd(String phoneNumber, TradeOffBodyRequestDTO tradeOffBodyRequest) {
        return null;
    }

}
