package br.com.alura.challange.Adopet.Domain.Abrigo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbrigoRepository extends JpaRepository<Abrigo, Long> {
    Page<Abrigo> findAll(Pageable paginacao);

}
