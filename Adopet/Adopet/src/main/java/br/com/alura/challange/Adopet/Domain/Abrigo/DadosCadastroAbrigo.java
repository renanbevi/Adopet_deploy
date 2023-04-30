package br.com.alura.challange.Adopet.Domain.Abrigo;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroAbrigo(
        @NotBlank(message = "nome do abrigo é obrigatório")
        String nome,
        @NotBlank(message = "Cidade do abrigo é obrigatório")
        String cidade,
        @NotBlank(message = "Estado do abrigo é obrigatório")
        String estado


) {
}
