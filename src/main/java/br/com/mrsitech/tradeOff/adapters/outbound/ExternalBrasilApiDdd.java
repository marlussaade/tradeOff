package br.com.mrsitech.tradeOff.adapters.outbound;

import br.com.mrsitech.tradeOff.application.mappers.dto.BrasilApiGetDddResponseDTO;
import br.com.mrsitech.tradeOff.application.mappers.dto.DddRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "brasilapiddd", url = "https://brasilapi.com.br/api/ddd/v1")
public interface ExternalBrasilApiDdd {
    @GetMapping("/{ddd}")
    BrasilApiGetDddResponseDTO getDddBrasilApi(

    @PathVariable (name = "ddd", required = true) String ddd
    );
}
