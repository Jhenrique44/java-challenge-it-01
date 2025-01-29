package main.java.com.javajh.trasacao_challenge_api.business.services;

import lombok.RequiredArgsConstructor;

import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    public final TransacaoService transacaoService;

    public StatisticsResponseDTO calculateStatisticsTransactions(Integer intervaloBusca) {
        List<TransacaoRequestDTO> trasacoes = transacaoService.findTransactions(intervaloBusca);

        DoubleSummaryStatistics statisticsTransactions = transacoes.stream().mapToDouble(TransacaoRequestDTO::valor)
                .summaryStatistics();
        return new StatisticsResponseDTO(statisticsTransactions.getCount(), statisticsTransactions.getSum(),
                statisticsTransactions.getAverage(), statisticsTransactions.getMin(), statisticsTransactions.getMax());
    }

}
