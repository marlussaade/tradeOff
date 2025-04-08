package br.com.marlussaade.mstradeoffprocessorv1.application.port.out;

import br.com.marlussaade.mstradeoffprocessorv1.application.core.dto.ProteinTradeOffRequestDTO;
import br.com.marlussaade.mstradeoffprocessorv1.application.core.dto.ProteinTradeOffResultDTO;

public interface TradeOffRespondMapping {

    ProteinTradeOffResultDTO tradeOffRespondMapping(ProteinTradeOffRequestDTO proteinTradeOffRequestDTO);
}
