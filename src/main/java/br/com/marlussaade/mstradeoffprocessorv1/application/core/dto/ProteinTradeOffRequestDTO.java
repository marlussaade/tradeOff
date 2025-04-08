package br.com.marlussaade.mstradeoffprocessorv1.application.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProteinTradeOffRequestDTO {
    private String phoneNumber;
    private List<WheyDTO> wheys;
}
