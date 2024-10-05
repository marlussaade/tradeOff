package br.com.mrsitech.tradeOff.application.services;

import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffBodyRequestDTO;
import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.TradeOffResponseDTO;
import br.com.mrsitech.tradeOff.adapters.inbound.rest.dto.WheyDTO;
import br.com.mrsitech.tradeOff.application.mappers.dto.BrasilApiGetDddResponseDTO;
import br.com.mrsitech.tradeOff.application.mappers.dto.DddRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;

public class MockCalculationAndFindDddServiceTest {
    @Autowired
    DddRequestDTO dddRequestDTO;

    @Autowired
    TradeOffBodyRequestDTO tradeOffBodyRequestDTO;

    public static String mockNumberPhone() {
        return "41996447054";
    }
    public static DddRequestDTO mockDdd() {
        return DddRequestDTO.builder().ddd("41").build();
    }
    public static BrasilApiGetDddResponseDTO mockApiBrasilResponseDdd() {
        return BrasilApiGetDddResponseDTO.builder().state("PR").cities(
                Collections.singletonList("[\n" +
                        "        \"DOUTOR ULYSSES\",\n" +
                        "        \"TUNAS DO PARANÁ\",\n" +
                        "        \"TIJUCAS DO SUL\",\n" +
                        "        \"SÃO JOSÉ DOS PINHAIS\",\n" +
                        "        \"RIO BRANCO DO SUL\",\n" +
                        "        \"QUITANDINHA\",\n" +
                        "        \"QUATRO BARRAS\",\n" +
                        "        \"PONTAL DO PARANÁ\",\n" +
                        "        \"PIRAQUARA\",\n" +
                        "        \"PINHAIS\",\n" +
                        "        \"PIÊN\",\n" +
                        "        \"PARANAGUÁ\",\n" +
                        "        \"MORRETES\",\n" +
                        "        \"MATINHOS\",\n" +
                        "        \"MANDIRITUBA\",\n" +
                        "        \"LAPA\",\n" +
                        "        \"ITAPERUÇU\",\n" +
                        "        \"GUARATUBA\",\n" +
                        "        \"GUARAQUEÇABA\",\n" +
                        "        \"FAZENDA RIO GRANDE\",\n" +
                        "        \"CURITIBA\",\n" +
                        "        \"CONTENDA\",\n" +
                        "        \"COLOMBO\",\n" +
                        "        \"CERRO AZUL\",\n" +
                        "        \"CAMPO MAGRO\",\n" +
                        "        \"CAMPO LARGO\",\n" +
                        "        \"CAMPO DO TENENTE\",\n" +
                        "        \"CAMPINA GRANDE DO SUL\",\n" +
                        "        \"BOCAIÚVA DO SUL\",\n" +
                        "        \"BALSA NOVA\",\n" +
                        "        \"ARAUCÁRIA\",\n" +
                        "        \"ANTONINA\",\n" +
                        "        \"ALMIRANTE TAMANDARÉ\",\n" +
                        "        \"AGUDOS DO SUL\",\n" +
                        "        \"ADRIANÓPOLIS\"\n" +
                        "    ]")
        ).build();
    }

    public static TradeOffBodyRequestDTO mockTradeOffBodyRequestDTO() {
        return TradeOffBodyRequestDTO.builder().phoneNumber("41996447054").wheys(
                Arrays.asList(
                        WheyDTO.builder().productNumber(1).priceOfPack(65.50).weightPackInGrams(450).dosePerGrams(32).proteinsPerDose(21).build(),
                        WheyDTO.builder().productNumber(2).priceOfPack(70.50).weightPackInGrams(450).dosePerGrams(32).proteinsPerDose(18).build()
                )
        ).build();
    }
    public static TradeOffResponseDTO resultPostCalculationAndFindDddExpetation() {
        return TradeOffResponseDTO.builder()
                .numberPhone("41996447054")
                .howIsBetter("The first and second has the same value per grams of proteins: Whey 1 (0.14242424242424243 cents/grams), Whey 2 (0.14242424242424243cents/grams)")
                .build();

    }
}
