package br.com.mrsitech.tradeOff.adapters.inbound.rest;

import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffBodyRequestDTO;
import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffResponseDTO;
import br.com.mrsitech.tradeOff.application.mappers.dto.BrasilApiGetDddResponseDTO;
import br.com.mrsitech.tradeOff.application.port.CalculationAndFindDddInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TradeOffControllerImpl implements TradeOffController {

    @Autowired
    CalculationAndFindDddInterface calculationAndFindDddInterface;

    public @PostMapping(value = "/proteinTradeOff/{phoneNumber}")
    ResponseEntity<TradeOffResponseDTO> postProteinTradeOff(
            @PathVariable(value = "phoneNumber", required = true) String phoneNumber,
            @RequestBody (required = false)  TradeOffBodyRequestDTO tradeOffBodyRequest
    ) {

        return ResponseEntity.ok(calculationAndFindDddInterface.postCalculationAndFindDdd(phoneNumber, tradeOffBodyRequest));
    }

}
