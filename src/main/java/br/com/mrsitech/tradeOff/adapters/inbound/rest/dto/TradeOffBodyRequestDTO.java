package br.com.mrsitech.tradeOff.adapters.inbound.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TradeOffBodyRequestDTO {
    private String phoneNumber;
    private List<WheysDTO> wheys;
}
