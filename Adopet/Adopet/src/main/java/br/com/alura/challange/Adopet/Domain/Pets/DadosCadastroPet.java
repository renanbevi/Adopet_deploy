package br.com.alura.challange.Adopet.Domain.Pets;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPet(

        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @NotBlank(message = "Descrição do pet é obrigatório")
        String descricao,
        @NotNull
        Boolean adotado,
        @NotBlank(message = "Descrição idade é obrigatório")
        String idade,
        @NotBlank(message = "imagem obrigatória")
        String imagem,

        Long idAbrigo

) {
}
