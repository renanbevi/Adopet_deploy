package br.com.alura.challange.Adopet.Domain.Tutor;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TutoresRepository extends JpaRepository<Tutor, Long> {

    Page<Tutor> findAll(Pageable paginacao);

}
