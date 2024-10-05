package br.com.mrsitech.tradeOff.application.mappers;

import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffBodyRequestDTO;
import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffResponseDTO;
import br.com.mrsitech.tradeOff.application.mappers.dto.BrasilApiGetDddResponseDTO;
import org.apache.logging.log4j.CloseableThreadContext;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class TradeOffRespondMappingImpl implements TradeOffRespondMapping {
    @Override
    public TradeOffResponseDTO tradeOffRespondMapping(BrasilApiGetDddResponseDTO brasilApiGetDddResponseDTO, TradeOffBodyRequestDTO tradeOffBodyRequestDTO) {

        TradeOffResponseDTO tradeOffResponseDTO = TradeOffResponseDTO.builder().numberPhone(tradeOffBodyRequestDTO.getPhoneNumber())
                .howIsBetter(calculationCheaperPrice(tradeOffBodyRequestDTO))
                .protocol(UUID.randomUUID().toString())
                .timestamp(DateTimeFormatter
                        .ofPattern("yyyy-MM-dd HH:mm:ss")
                        .withZone(ZoneId.of("UTC"))
                        .format(Instant.now()))
                .build();


        return tradeOffResponseDTO;
    }
    public String calculationCheaperPrice(TradeOffBodyRequestDTO tradeOffBodyRequestDTO){

        double payPerProteinOne = 0;
        double payPerProteinTwo = 0;

        if (tradeOffBodyRequestDTO.getWheys().get(0).getProductNumber() == 1){
            double payPerPackGrams = (tradeOffBodyRequestDTO.getWheys().get(0).getPriceOfPack()/tradeOffBodyRequestDTO.getWheys().get(0).getWeightPackInGrams());
            double payPerDoseGrams = (tradeOffBodyRequestDTO.getWheys().get(0).getProteinsPerDose()/tradeOffBodyRequestDTO.getWheys().get(0).getDosePerGrams());
            payPerProteinOne = payPerPackGrams/payPerDoseGrams;
        }

        if (tradeOffBodyRequestDTO.getWheys().get(1).getProductNumber() == 2){
            double payPerPackGrams = (tradeOffBodyRequestDTO.getWheys().get(1).getPriceOfPack()/tradeOffBodyRequestDTO.getWheys().get(1).getWeightPackInGrams());
            double payPerDoseGrams = (tradeOffBodyRequestDTO.getWheys().get(1).getProteinsPerDose()/tradeOffBodyRequestDTO.getWheys().get(1).getDosePerGrams());
            payPerProteinTwo = payPerPackGrams/payPerDoseGrams;
        }



        if(payPerProteinTwo > payPerProteinOne){
            return "The first whey is cheaper per grams of proteins: Whey 1 ("+payPerProteinOne+" cents/grams), Whey 2 ("+payPerProteinTwo +"cents/grams)";
        } else if (payPerProteinOne > payPerProteinTwo) {
            return "The second whey is cheaper per grams of proteins: Whey 1 ("+payPerProteinOne+" cents/grams), Whey 2 ("+payPerProteinTwo +"cents/grams)";
        } else return "The first and second has the same value per grams of proteins: Whey 1 ("+payPerProteinOne+" cents/grams), Whey 2 ("+payPerProteinTwo +"cents/grams)";


    }
}
