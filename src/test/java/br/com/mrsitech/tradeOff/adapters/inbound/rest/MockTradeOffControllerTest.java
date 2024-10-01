package br.com.mrsitech.tradeOff.adapters.inbound.rest;

import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffBodyRequestDTO;
import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffResponseDTO;
import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.WheysDTO;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MockTradeOffControllerTest {



    public static String mockOffShouldReturnOkStatusForPostTradeOff() {
        return "Este Whey Protein tem o custo de 6 centavos por grama proteina.";
    }

    public static String mockOfShouldReturnOkStatusForPostTradeOff() {
        return "{"
                + "\"telefoneNumber\":\"41996447054\","
                + "\"wheys\":[{"
                + "\"whey\":{"
                + "\"pack\":{"
                + "\"valuePackReais\":65.50,"
                + "\"weightPackGramas\":450"
                + "},"
                + "\"nutritional\":{"
                + "\"weightScope\":31,"
                + "\"proteinByScope\":22"
                + "}}}]"
                + "}";
    }
    public static TradeOffBodyRequestDTO mockOfTradeOffRequestDTO() {


        return TradeOffBodyRequestDTO.builder().phoneNumber("41996447054").wheys(
                Arrays.asList(
                    WheysDTO.builder().productNumber(1).priceOfPack(65.50).weightPackInGrams(450).dosePerGrams(32).proteinsPerDose(21).build(),
                    WheysDTO.builder().productNumber(2).priceOfPack(70.50).weightPackInGrams(450).dosePerGrams(32).proteinsPerDose(18).build()
                )
        ).build();

    }


    public static TradeOffResponseDTO mockOfTradeOffResponseDTO() {

        return TradeOffResponseDTO.builder()
                .numberPhone("41996447054")
                .howIsBetter("The first whey is cheaper per grams of proteins: Whey 1 (0.56 cents/grams), Whey 2 (0.74 cents/grams)")
                .timestamp(
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                        .withZone(ZoneId.of("UTC"))
                        .format(Instant.now())
                )
                .protocol(UUID.randomUUID().toString()).build();
    }
}
