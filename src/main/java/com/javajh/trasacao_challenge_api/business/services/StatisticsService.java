package main.java.com.javajh.trasacao_challenge_api.business.services;

import lombok.RequiredArgsConstructor;

import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatisticsService {

    public final TransacaoService transacaoService;

    public StatisticsResponseDTO calculateStatisticsTransactions(Integer intervaloBusca) {
        log.info("Initializing find statistics and transactions for the period " + intervaloBusca);
        List<TransacaoRequestDTO> trasacoes = transacaoService.findTransactions(intervaloBusca);
        if(trasacoes.isEmpyt()) { 
            return new StatisticsResponseDTO(0L, 0L, 0L, 0L, 0L);
        }
        DoubleSummaryStatistics statisticsTransactions = transacoes.stream().mapToDouble(TransacaoRequestDTO::valor)
                .summaryStatistics();
        log.info("Statistics returned sucessfully");
        return new StatisticsResponseDTO(statisticsTransactions.getCount(), statisticsTransactions.getSum(),
                statisticsTransactions.getAverage(), statisticsTransactions.getMin(), statisticsTransactions.getMax());
    }

}
