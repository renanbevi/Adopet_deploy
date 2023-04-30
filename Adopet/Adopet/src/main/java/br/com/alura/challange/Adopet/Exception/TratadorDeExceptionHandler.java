package br.com.alura.challange.Adopet.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;


public class TratadorDeExceptionHandler {


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity tratarErroDeValidacao(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(new DadosErro400(LocalDateTime.now(), ex.getMessage()));
    }

    private record DadosErro400(LocalDateTime timestamp, String message) {}
}
