package br.com.marlussaade.mstradeoffprocessorv1.application.port.in;

import br.com.marlussaade.mstradeoffprocessorv1.application.core.dto.ProteinTradeOffRequestDTO;
import br.com.marlussaade.mstradeoffprocessorv1.application.core.dto.ProteinTradeOffResultDTO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@OpenAPIDefinition(
        info = @Info(
                title = "TradeOff Processor API",
                version = "1.0.0",
                description = "API for processing trade-offs in protein data.",
                contact = @Contact(
                        name = "Marlus Saade",
                        email = "marlusrsaade@gmail.com",
                        url = "https://github.com/marlussaade/tradeOff"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "Local Server"),
                @Server(url = "https://api.tradeoff.com", description = "Production Server")
        }
)
@Tag(name = "Trade-Off Processor API", description = "Handles protein trade-off calculations")


public interface TradeOffProcessorController {
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProteinTradeOffResultDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "402", description = "Payment Required"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            @ApiResponse(responseCode = "501", description = "Not Implemented"),
            @ApiResponse(responseCode = "502", description = "Gateway Error"),
            @ApiResponse(responseCode = "503", description = "Gateway Timeout"),
    })


    @Operation(
            summary = "Calculate Protein Trade-Off",
            description = "Processes trade-off calculations based on protein data and returns the result."
    )
    @PostMapping(value = "/proteinTradeOff/{phoneNumber}")
    ResponseEntity<ProteinTradeOffResultDTO> calculationProteinTradeOff(
            @PathVariable(value = "phoneNumber", required = true) String phoneNumber,
            @RequestBody(required = false) ProteinTradeOffRequestDTO tradeOffBodyRequest
    );

}
