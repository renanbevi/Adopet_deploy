package br.com.alura.challange.Adopet.Domain.Abrigo;

public record DadosListagemAbrigo(Long id, String nome, String cidade, String estado) {

    public DadosListagemAbrigo(Abrigo abrigo){
        this(abrigo.getId(), abrigo.getNome(), abrigo.getCidade(), abrigo.getEstado());
    }


}
