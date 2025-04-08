package br.com.marlussaade.mstradeoffprocessorv1.application.port.in;

import br.com.marlussaade.mstradeoffprocessorv1.application.core.dto.ProteinTradeOffRequestDTO;
import br.com.marlussaade.mstradeoffprocessorv1.application.core.dto.ProteinTradeOffResultDTO;

public interface ProcessTradeOff {
    ProteinTradeOffResultDTO calculateAndCreateEvent(String phoneNumber, ProteinTradeOffRequestDTO tradeOffBodyRequest);
}
