package br.com.mrsitech.tradeOff.adapters.inbound.rest;

import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffBodyRequestDTO;
import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffResponseDTO;
import br.com.mrsitech.tradeOff.application.mappers.dto.BrasilApiGetDddResponseDTO;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface TradeOffController {
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = BrasilApiGetDddResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "402", description = "Payment Required"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            @ApiResponse(responseCode = "501", description = "Not Implemented"),
            @ApiResponse(responseCode = "502", description = "Gateway Error"),
            @ApiResponse(responseCode = "503", description = "Gateway Timeout"),
    })

    @PostMapping(value = "/proteinTradeOff/{phoneNumber}")
    ResponseEntity<TradeOffResponseDTO> postProteinTradeOff(
            @PathVariable(value = "phoneNumber", required = true) String phoneNumber,
            @RequestBody (required = false) TradeOffBodyRequestDTO tradeOffBodyRequest
    );

}
