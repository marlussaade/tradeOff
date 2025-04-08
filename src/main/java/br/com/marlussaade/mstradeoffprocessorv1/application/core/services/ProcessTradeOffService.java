package br.com.marlussaade.mstradeoffprocessorv1.application.core.services;

import br.com.marlussaade.mstradeoffprocessorv1.application.core.dto.ProteinTradeOffResultDTO;
import br.com.marlussaade.mstradeoffprocessorv1.application.core.dto.ProteinTradeOffRequestDTO;
import br.com.marlussaade.mstradeoffprocessorv1.application.port.in.ProcessTradeOff;
import br.com.marlussaade.mstradeoffprocessorv1.application.port.out.PublishTradeOffProcessed;
import br.com.marlussaade.mstradeoffprocessorv1.application.port.out.TradeOffRespondMapping;
import org.springframework.stereotype.Service;


@Service
public class ProcessTradeOffService implements ProcessTradeOff {

    private final TradeOffRespondMapping tradeOffRespondMapping;

    private final PublishTradeOffProcessed publishTradeOffProcessed;

    public ProcessTradeOffService(TradeOffRespondMapping tradeOffRespondMapping, PublishTradeOffProcessed publishTradeOffProcessed) {
        this.tradeOffRespondMapping = tradeOffRespondMapping;
        this.publishTradeOffProcessed = publishTradeOffProcessed;
    }


    @Override
    public ProteinTradeOffResultDTO calculateAndCreateEvent(String phoneNumber, ProteinTradeOffRequestDTO proteinTradeOffRequestDTO) {

        //Cheaper price
        ProteinTradeOffResultDTO proteinTradeOffResultDTO = tradeOffRespondMapping.tradeOffRespondMapping(proteinTradeOffRequestDTO);

        //Send to Kafka
        publishTradeOffProcessed.publishClientInteractionTradeOffProcessor(proteinTradeOffResultDTO);

        return proteinTradeOffResultDTO;
    }

}