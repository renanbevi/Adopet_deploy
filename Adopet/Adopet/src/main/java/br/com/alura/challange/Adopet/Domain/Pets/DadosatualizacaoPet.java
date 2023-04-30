package br.com.alura.challange.Adopet.Domain.Pets;

public record DadosatualizacaoPet(

        Long id,
        String nome,
        String descricao,
        Boolean adotado,
        String idade,
        String imagem,
        Long idAbrigo
) {


}
