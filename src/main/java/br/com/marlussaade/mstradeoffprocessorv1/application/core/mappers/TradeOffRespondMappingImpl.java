package br.com.marlussaade.mstradeoffprocessorv1.application.core.mappers;

import br.com.marlussaade.mstradeoffprocessorv1.application.core.dto.ProteinTradeOffRequestDTO;
import br.com.marlussaade.mstradeoffprocessorv1.application.core.dto.ProteinTradeOffResultDTO;
import br.com.marlussaade.mstradeoffprocessorv1.application.port.out.TradeOffRespondMapping;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class TradeOffRespondMappingImpl implements TradeOffRespondMapping {
    @Override
    public ProteinTradeOffResultDTO tradeOffRespondMapping(ProteinTradeOffRequestDTO proteinTradeOffRequestDTO) {

        ProteinTradeOffResultDTO proteinTradeOffResultDTO = ProteinTradeOffResultDTO.builder().numberPhone(proteinTradeOffRequestDTO.getPhoneNumber())
                .howIsBetter(calculationCheaperPrice(proteinTradeOffRequestDTO))
                .protocol(UUID.randomUUID().toString())
                .timestamp(DateTimeFormatter
                        .ofPattern("yyyy-MM-dd HH:mm:ss")
                        .withZone(ZoneId.of("UTC"))
                        .format(Instant.now()))
                .build();

        return proteinTradeOffResultDTO;
    }
    public String calculationCheaperPrice(ProteinTradeOffRequestDTO proteinTradeOffRequestDTO){

        double payPerProteinOne = 0;
        double payPerProteinTwo = 0;

        if (proteinTradeOffRequestDTO.getWheys().get(0).getProductNumber() == 1){
            double payPerPackGrams = (proteinTradeOffRequestDTO.getWheys().get(0).getPriceOfPack()/ proteinTradeOffRequestDTO.getWheys().get(0).getWeightPackInGrams());
            double payPerDoseGrams = (proteinTradeOffRequestDTO.getWheys().get(0).getProteinsPerDose()/ proteinTradeOffRequestDTO.getWheys().get(0).getDosePerGrams());
            payPerProteinOne = payPerPackGrams/payPerDoseGrams;
        }

        if (proteinTradeOffRequestDTO.getWheys().get(1).getProductNumber() == 2){
            double payPerPackGrams = (proteinTradeOffRequestDTO.getWheys().get(1).getPriceOfPack()/ proteinTradeOffRequestDTO.getWheys().get(1).getWeightPackInGrams());
            double payPerDoseGrams = (proteinTradeOffRequestDTO.getWheys().get(1).getProteinsPerDose()/ proteinTradeOffRequestDTO.getWheys().get(1).getDosePerGrams());
            payPerProteinTwo = payPerPackGrams/payPerDoseGrams;
        }

        if(payPerProteinTwo > payPerProteinOne){
            return "The first whey is cheaper per grams of proteins: Whey 1 ("+payPerProteinOne+" cents/grams), Whey 2 ("+payPerProteinTwo +"cents/grams)";
        } else if (payPerProteinOne > payPerProteinTwo) {
            return "The second whey is cheaper per grams of proteins: Whey 1 ("+payPerProteinOne+" cents/grams), Whey 2 ("+payPerProteinTwo +"cents/grams)";
        } else return "The first and second has the same value per grams of proteins: Whey 1 ("+payPerProteinOne+" cents/grams), Whey 2 ("+payPerProteinTwo +"cents/grams)";

    }

}
