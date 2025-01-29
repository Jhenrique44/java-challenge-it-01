package main.java.com.javajh.trasacao_challenge_api.controller.dtos;

import java.time.OffsetDateTime;

// padrã record substuição de calsse
public record TrasacaoRequestDTO(Double valor, OffsetDateTime dataValor) {
    
}
