package br.com.alura.challange.Adopet.Infra.Exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //dizer ao spring classe que trata erros
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)//Quando esse metodo vai ser chamado pra essa  exception
    public ResponseEntity tratarErro404(){

        return ResponseEntity.notFound().build();  // Build cria a exception.
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)//Quando esse metodo vai ser chamado pra essa  exception
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors(); //capturando a exception para ver os campos inválidos

        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList()); //Body devolve o objeto com as informações no corpo da respostas
    }

    private record DadosErroValidacao(String campo, String mensagem){
        public DadosErroValidacao(FieldError erro){ //

            this(erro.getField(), erro.getDefaultMessage()); //construtor padrão Getfield dá o nome do campo  default Menssage dá a mensagem para o campo em especifico
        }

    }

}
