package br.com.mrsitech.tradeOff.adapters.inbound.rest;

public class MockTradeOffControllerTest {

    public static String mockOffShouldReturnOkStatusForGetTradeOff() {
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

}
