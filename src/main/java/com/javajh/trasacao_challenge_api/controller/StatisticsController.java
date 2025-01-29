package main.java.com.javajh.trasacao_challenge_api.controller;

import main.java.com.javajh.trasacao_challenge_api.business.services.StatisticsService;
import main.java.com.javajh.trasacao_challenge_api.controller.dtos.StatisticsResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class StatisticsController {
    private final StatisticsService statisticsService;

    @GetMapping
    @Operation(description = "Endpoint for find statistics of transactions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search sucessfully"),
            @ApiResponse(responseCode = "400", description = "Error of searching statistics"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<StatisticsResponseDTO> findStatistics(
            @RequestParam(value = "intervaloBusca", required = false, defaultValue = "60") Integer intervaloBusca) {

        return ResponseEntity.ok(statisticsService.calculateStatisticsTransactions(intervaloBusca));
    }
}
