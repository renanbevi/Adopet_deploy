package br.com.alura.challange.Adopet.Domain.Tutor;

import jakarta.persistence.*;
import lombok.*;

//Classe que representa os campos que estão dentro do Banco de dados.

@Entity
@Table(name ="tutores")


@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= "id")
@ToString(of = {"id" , "nome", "email"})
public class Tutor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;



    //Abaixo o this que é nossa entidade puxa as informações do dados.nome que vem do Record.
    public Tutor(DadosCadastroTutor dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();

    }

    public void atualizaInformacoes(DadosAtualizacaoTutor dados){

        if(dados.nome() != null) {
            this.nome = dados.nome();
        }

        if(dados.email() != null){
            this.email = dados.email();
        }

    }

}
