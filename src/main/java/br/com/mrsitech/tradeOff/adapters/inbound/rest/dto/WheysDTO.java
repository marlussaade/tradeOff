package br.com.mrsitech.tradeOff.adapters.inbound.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WheysDTO {

    private int productNumber;
    private Double priceOfPack;
    private int weightPackInGrams;
    private int dosePerGrams;
    private int proteinsPerDose;

}
