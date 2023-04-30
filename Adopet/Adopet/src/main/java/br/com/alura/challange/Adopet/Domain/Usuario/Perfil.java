package br.com.alura.challange.Adopet.Domain.Usuario;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Entity(name = "Perfil")
@Table(name = "perfis")

@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "nome"})
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Perfil implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Override
    public String getAuthority() {
        return nome;
    }

}
