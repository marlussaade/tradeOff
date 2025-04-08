package br.com.marlussaade.mstradeoffprocessorv1.adapters.inbound.rest;

import br.com.marlussaade.mstradeoffprocessorv1.application.core.dto.ProteinTradeOffRequestDTO;
import br.com.marlussaade.mstradeoffprocessorv1.application.core.dto.ProteinTradeOffResultDTO;
import br.com.marlussaade.mstradeoffprocessorv1.application.port.in.ProcessTradeOff;
import br.com.marlussaade.mstradeoffprocessorv1.application.port.in.TradeOffProcessorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeOffProcessorControllerImpl implements TradeOffProcessorController {

    private final ProcessTradeOff ProcessTradeOff;

    public TradeOffProcessorControllerImpl(ProcessTradeOff calculationProteinTradeOff) {
        this.ProcessTradeOff = calculationProteinTradeOff;
    }

    @Override
    @PostMapping(value = "/proteinTradeOff/{phoneNumber}")
    public ResponseEntity<ProteinTradeOffResultDTO> calculationProteinTradeOff(
            @PathVariable(value = "phoneNumber", required = true) String phoneNumber,
            @RequestBody(required = true) ProteinTradeOffRequestDTO tradeOffBodyRequest
    ) {

        return ResponseEntity.ok(ProcessTradeOff.calculateAndCreateEvent(phoneNumber, tradeOffBodyRequest));
    }

}