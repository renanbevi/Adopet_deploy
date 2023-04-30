package br.com.alura.challange.Adopet.Domain.Pets;


import br.com.alura.challange.Adopet.Domain.Abrigo.Abrigo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "pets")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= "id")
@ToString(of = {"id","nome","descricao", "adotado","idade","imagem"})

public class Pets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Boolean adotado;
    private String idade;
    private String imagem;

    @ManyToOne
    @JoinColumn(name = "abrigo_id")
    private Abrigo abrigo;

    public Pets(DadosCadastroPet dados, Abrigo abrigo) {
       this.nome = dados.nome();
       this.descricao = dados.descricao();
       this.adotado = dados.adotado();
       this.idade = dados.idade();
       this.imagem = dados.imagem();
       this.abrigo = abrigo;

    }

    public void atualizadados(DadosatualizacaoPet dados, Abrigo abrigo) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.descricao() != null){
            this.descricao = dados.descricao();
        }
        if (dados.adotado() != null){
            this.adotado = dados.adotado();
        }

        if (dados.imagem() != null){
            this.imagem = dados.imagem() ;
        }
        if (dados.idAbrigo() != null){
            this.abrigo = abrigo;
        }
    }

    public void marcarComoAdotado() {

        this.adotado = true;
    }

    public void marcarComoNaoAdotado(){
        this.adotado = false;
    }
}
