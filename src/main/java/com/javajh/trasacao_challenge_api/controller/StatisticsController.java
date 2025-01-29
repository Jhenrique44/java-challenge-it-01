package main.java.com.javajh.trasacao_challenge_api.controller;

import main.java.com.javajh.trasacao_challenge_api.business.services.StatisticsService;

@RestController
@RequestMapping("/estatistica")
public class StatisticsController {
    private final StatisticsService statisticsService;

    public ResponseEntity<StatisticsResponseDTO> findStatistics(
            @RequestParam(value = "intervaloBusca", required = false, defaultValue = "60") Integer intervaloBusca) {

        return ResponseEntity.ok(statisticsService.calculateStatisticsTransactions(intervaloBusca));
    }
}
