package br.com.marlussaade.mstradeoffprocessorv1.application.port.out;

import br.com.marlussaade.mstradeoffprocessorv1.application.core.dto.ProteinTradeOffResultDTO;

public interface PublishTradeOffProcessed {


    void publishClientInteractionTradeOffProcessor(ProteinTradeOffResultDTO proteinTradeOffResultDTO);

}
