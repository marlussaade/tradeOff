package br.com.mrsitech.tradeOff.application.services;

import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffResponseDTO;
import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffBodyRequestDTO;
import br.com.mrsitech.tradeOff.adapters.outbound.ExternalBrasilApiDdd;
import br.com.mrsitech.tradeOff.application.mappers.BrasilApiDddRequestMapping;
import br.com.mrsitech.tradeOff.application.mappers.TradeOffRespondMapping;
import br.com.mrsitech.tradeOff.application.mappers.dto.BrasilApiGetDddResponseDTO;
import br.com.mrsitech.tradeOff.application.mappers.dto.DddRequestDTO;
import br.com.mrsitech.tradeOff.application.port.CalculationAndFindDddInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CalculationAndFindDddService implements CalculationAndFindDddInterface {
    @Autowired
    BrasilApiDddRequestMapping brasilApiDddMapping;

    @Autowired
    ExternalBrasilApiDdd externalBrasilApiDdd;

    @Autowired
    TradeOffRespondMapping tradeOffRespondMapping;

    @Override
    public TradeOffResponseDTO postCalculationAndFindDdd(String phoneNumber, TradeOffBodyRequestDTO tradeOffBodyRequestDTO) {

        //Store State through the DDD
      DddRequestDTO requestToBrasilApiDdd = brasilApiDddMapping.brasilApiMappingToGetDdd(phoneNumber);
      String ddd = requestToBrasilApiDdd.getDdd();
      BrasilApiGetDddResponseDTO brasilApiGetDddResponseDTO = externalBrasilApiDdd.getDddBrasilApi(ddd);

      //Cheaper price
        TradeOffResponseDTO tradeOffResponseDTO = tradeOffRespondMapping.tradeOffRespondMapping(brasilApiGetDddResponseDTO, tradeOffBodyRequestDTO);

        return tradeOffResponseDTO;


    }
}
