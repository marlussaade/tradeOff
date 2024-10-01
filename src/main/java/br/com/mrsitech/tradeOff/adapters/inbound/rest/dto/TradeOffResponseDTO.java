package br.com.mrsitech.tradeOff.adapters.inbound.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TradeOffResponseDTO {

    private String numberPhone;
    private String howIsBetter;
    private String timestamp;
    private String protocol;
}
