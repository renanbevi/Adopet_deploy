package br.com.alura.challange.Adopet.Domain.Pets;

public record DadosListagemPets(
        Long id,
        String nome,
        String descricao,
        Boolean adotado,
        String idade,
        String imagem
) {

    public  DadosListagemPets(Pets pets){

        this(pets.getId(), pets.getNome(), pets.getDescricao(), pets.getAdotado(), pets.getIdade(), pets.getImagem());

    }





}
