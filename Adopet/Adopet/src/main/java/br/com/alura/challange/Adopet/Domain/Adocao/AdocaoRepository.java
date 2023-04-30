package br.com.alura.challange.Adopet.Domain.Adocao;

import br.com.alura.challange.Adopet.Domain.Pets.Pets;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdocaoRepository extends JpaRepository<Adocao,Long> {

    Page<Adocao> findAll(Pageable paginacao);
}
