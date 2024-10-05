package br.com.mrsitech.tradeOff.adapters.inbound.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WheyDTO {

    private double productNumber;
    private double priceOfPack;
    private double weightPackInGrams;
    private double dosePerGrams;
    private double proteinsPerDose;

}
