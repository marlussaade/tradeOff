package br.com.mrsitech.tradeOff.application.mappers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DddRequestDTO {
    private String ddd;
}
