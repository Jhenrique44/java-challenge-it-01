package main.java.com.javajh.trasacao_challenge_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import main.java.com.javajh.trasacao_challenge_api.business.services.TransacaoService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<Void> addTransacao(@RequestBody Transacao transacao) {
        // Implementar a lógica para cadastrar uma nova transação
        // Retornar o status HTTP 201 e a transação cadastrada
        transacaoService.addTransacoes(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTransacoes() {
        transacaoService.deleteTransacoes();
        return ResponseEntity.ok().build();
    }
}
