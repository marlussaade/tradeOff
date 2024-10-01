package br.com.mrsitech.tradeOff.adapters.inbound.rest;

import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffBodyRequestDTO;
import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffResponseDTO;
import br.com.mrsitech.tradeOff.application.port.CalculationAndFindDddInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeOffControllerImpl implements TradeOffController {

    @Autowired
    CalculationAndFindDddInterface calculationAndFindDddInterface;

    public @PostMapping(value = "/proteinTradeOff/{phoneNumber}")
    ResponseEntity<TradeOffResponseDTO> postProteinTradeOff(
            @PathVariable(value = "phoneNumber", required = true) String phoneNumber,
            @RequestBody TradeOffBodyRequestDTO tradeOffBodyRequest
    ) {

        return ResponseEntity.ok(calculationAndFindDddInterface.postCalculationAndFindDdd(phoneNumber, tradeOffBodyRequest));
    }

}
