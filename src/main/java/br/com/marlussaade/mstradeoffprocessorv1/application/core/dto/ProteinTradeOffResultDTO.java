package br.com.marlussaade.mstradeoffprocessorv1.application.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProteinTradeOffResultDTO {

    private String numberPhone;
    private String howIsBetter;
    private String timestamp;
    private String protocol;
}
