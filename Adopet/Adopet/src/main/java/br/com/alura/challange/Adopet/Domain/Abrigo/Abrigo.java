package br.com.alura.challange.Adopet.Domain.Abrigo;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Entity
@Table(name= "abrigo")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= "id")
@ToString(of = {"nome","cidade","estado"})
public class Abrigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cidade;
    private String estado;



    public Abrigo(DadosCadastroAbrigo dados) {
        this.nome = dados.nome();
        this.cidade = dados.cidade();
        this.estado = dados.estado();

    }
    public void atualizarInformacoes(@Valid DadosAtualizacaoAbrigo dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.cidade() != null){
            this.cidade = dados.cidade();
        }
        if(dados.estado() != null){
            this.estado = dados.estado();
        }


    }
}
