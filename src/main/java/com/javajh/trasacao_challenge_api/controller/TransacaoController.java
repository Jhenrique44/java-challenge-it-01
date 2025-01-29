package main.java.com.javajh.trasacao_challenge_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.DeleteMapping;
import main.java.com.javajh.trasacao_challenge_api.business.services.TransacaoService;
import main.java.com.javajh.trasacao_challenge_api.controller.dtos.TrasacaoRequestDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    @PostMapping
    @Operation(description = "Endpoint for adding transactions")
    @ApiResponses(value ={ 
        @ApiResponse(responseCode = "201", description = "Transaction saved sucessfully"),
        @ApiResponse(responseCode = "422", description = "Fields not attend the required permissions"),
        @ApiResponse(responseCode = "400", description = "Requisition error"),
        @ApiResponse(responseCode = "500", description = "Internal server error")    
})
    public ResponseEntity<Void> addTransacao(@RequestBody Transacao transacao) {
        // Implementar a lógica para cadastrar uma nova transação
        // Retornar o status HTTP 201 e a transação cadastrada
        transacaoService.addTransacoes(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    
    @DeleteMapping
    @Operation(description = "Endpoint for deleting transactions")
    @ApiResponses(value ={ 
        @ApiResponse(responseCode = "200", description = "Transaction deleted sucessfully"),
        @ApiResponse(responseCode = "400", description = "Requisition error"),
        @ApiResponse(responseCode = "500", description = "Internal server error")    
})
    public ResponseEntity<Void> deleteTransacoes() {
        transacaoService.deleteTransacoes();
        return ResponseEntity.ok().build();
    }
}
