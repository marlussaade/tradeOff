package br.com.mrsitech.tradeOff.application.mappers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrasilApiGetDddResponseDTO {

        private String state;
        private List<String> cities;

}
