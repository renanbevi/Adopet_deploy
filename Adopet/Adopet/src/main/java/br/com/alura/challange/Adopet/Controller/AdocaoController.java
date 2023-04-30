package br.com.alura.challange.Adopet.Controller;


import br.com.alura.challange.Adopet.Domain.Adocao.*;

import br.com.alura.challange.Adopet.Domain.Pets.DadosListagemPets;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/adocao")
public class AdocaoController {

    @Autowired
    private AdocaoService service;
    @Autowired
    private AdocaoRepository adocaoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAdocao dados){
        var adocao = service.cadastroAdocao(dados);
        return ResponseEntity.ok(new DadosAdocao(adocao));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarAdocao(@PathVariable Long id){
        service.deletarAdocao(id);
        return ResponseEntity.ok("Adoção apagada com sucesso");


    }

    @GetMapping
    public Page<DadosAdocao> listarAdocao(@PageableDefault(size = 10, page = 0) Pageable paginacao){
        var page = adocaoRepository.findAll(paginacao).map(DadosAdocao::new);
        return ResponseEntity.ok(page).getBody();
    }

}
