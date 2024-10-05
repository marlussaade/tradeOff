package br.com.mrsitech.tradeOff.application.mappers;

import br.com.mrsitech.tradeOff.application.mappers.dto.DddRequestDTO;

public interface BrasilApiDddRequestMapping {
    DddRequestDTO brasilApiMappingToGetDdd(String phoneNumber);
}
