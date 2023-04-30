package br.com.alura.challange.Adopet.Domain.Adocao;



import br.com.alura.challange.Adopet.Domain.Pets.Pets;
import br.com.alura.challange.Adopet.Domain.Tutor.Tutor;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
;




@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "data"})

@Entity
@Table(name="adocoes")

public class Adocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pets pets;


      public Adocao(DadosCadastroAdocao dados, Tutor tutor, Pets pets){
          this.data = dados.data();
          this.tutor = tutor;
          this.pets = pets;


    }

}
