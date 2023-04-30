package br.com.alura.challange.Adopet.Domain.Pets;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetsRepository extends JpaRepository<Pets,Long> {



    Page<Pets> findAll(Pageable paginacao);


}
