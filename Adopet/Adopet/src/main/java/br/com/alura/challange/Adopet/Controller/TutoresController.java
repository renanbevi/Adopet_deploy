package br.com.alura.challange.Adopet.Controller;

import br.com.alura.challange.Adopet.Domain.Tutor.*;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;


@RestController
@RequestMapping("tutores")
public class TutoresController {

    @Autowired
    private TutoresRepository tutoresRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTutor dados) {

        if (!dados.senha().equals(dados.confirmacaoSenha())) {
            return ResponseEntity.badRequest().body("Senha ou confirmação de senha não válida");
        }

        tutoresRepository.save(new Tutor(dados));
        return ResponseEntity.ok("Tutor cadastrado com sucesso");
    }

    @GetMapping("/{id}")
    public ResponseEntity listarTutor(@PathVariable Long id) throws Exception {

        var tutor = tutoresRepository.getReferenceById(id);

        if (!tutoresRepository.existsById(id)) {
            throw new Exception("Id informado não existe");
        }
        return ResponseEntity.ok(new DadosListagemTutor(tutor));

    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarTutor(@RequestBody @Valid DadosAtualizacaoTutor dados) {
        try {
            var tutor = tutoresRepository.getReferenceById(dados.id());
            tutor.atualizaInformacoes(dados);
            return ResponseEntity.ok("Atualização efetuada com sucesso");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok("Tutor não encontrado");
        }

    }


    @GetMapping
    public ResponseEntity listar() {
        var tutores = tutoresRepository.findAll();
        if (tutores.isEmpty()) {
            return ResponseEntity.ok("Não encontrado");
        }
        return ResponseEntity.ok(tutores.stream().map(DadosListagemTutor::new).collect(Collectors.toList()));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deletarTutor(@PathVariable Long id){
        try{
        var tutor = tutoresRepository.getReferenceById(id);
        tutoresRepository.delete(tutor);
        return ResponseEntity.noContent().build();
        }catch (EntityNotFoundException e){
        return  ResponseEntity.ok("Tutor não encontrado para deletar");
        }


    }

}




