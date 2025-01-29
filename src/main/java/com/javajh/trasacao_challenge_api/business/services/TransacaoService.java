package main.java.com.javajh.trasacao_challenge_api.business.services;

import com.javajh.trasacao_challenge_api.dtos.TransacaoRequestDTO;
import main.java.com.javajh.trasacao_challenge_api.infrastructure.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.OffsetDateTime;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {

    // create list beacuse of non use of database
    private final List<TransacaoRequestDTO> listTransacoes = new ArrayList<>();

    public void addTransacoes(TransacaoRequestDTO dto) {
        log.info("Inicializando transacoes" + dto);
        if (dto.dataHora().isAfter(OffsetDateTime.now())) {
            log.error("Data e hora maiores que a data atual");
            throw new UnprocessableEntity("Data e hora maiores que a data atual.");
        }
        if (dto.valor() < 0) {
            log.error("Valor não pode ser menor que 0");
            throw new UnprocessableEntity("valor menor que 0.");
        }
        log.info("Transactions has been add successfully");
        listTransacoes.add(dto);
    }

    // delete transactions
    public void deleteTransacoes() {
        log.info("Deleting Transactions from memory");
        listTransacoes.clear();
    }

    // Define Interval for find the past transactions and return them all

    public List<TransacaoRequestDTO> findStatistics(Integer intervaloBusca) {
        log.info("Initialized search for transaction in time " + intervaloBusca);
        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloBusca);

        return listTransacoes.stream()
            .filter(transacao -> trasacao.dataHora()
                .isAfter(dataHoraIntervalo)).toList();
    }
}
