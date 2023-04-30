package br.com.alura.challange.Adopet.Domain.Tutor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


//Record representa os campos que estão chegando da API
public record DadosCadastroTutor(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String senha,
        @NotBlank
        String confirmacaoSenha) {



}
