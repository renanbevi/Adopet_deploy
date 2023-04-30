package br.com.alura.challange.Adopet.Domain.Adocao;

import br.com.alura.challange.Adopet.Domain.Pets.PetsRepository;
import br.com.alura.challange.Adopet.Domain.Tutor.TutoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class AdocaoService {


    @Autowired
    private PetsRepository petsRepository;
    @Autowired
    private TutoresRepository tutoresRepository;

    @Autowired
    private AdocaoRepository adocaoRepository;



    @PostMapping
    public Adocao cadastroAdocao(DadosCadastroAdocao dados) {

        var pet = petsRepository.findById(dados.petId()).orElseThrow(() -> new IllegalArgumentException("Pet não cadastrado!")); // orElseThrow Se um valor estiver presente, retorna o valor, caso contrário, lança a exceção informada no parâmetro
        if(pet.getAdotado()){
            throw new IllegalArgumentException("Pet já adotado!");
        }
        var tutor = tutoresRepository.findById(dados.tutorId()).orElseThrow(() -> new IllegalArgumentException("Tutor não cadastrado!"));
        var adocao = new Adocao(dados, tutor, pet);
        adocaoRepository.save(adocao);
        pet.marcarComoAdotado(); //Marca o PET como adotado no banco de dados

        return adocao;

    }
    public void deletarAdocao(Long id){
        var adocao = adocaoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Adoção não cadastrada"));
        var pet = petsRepository.findById(id).orElseThrow();
        pet.marcarComoNaoAdotado(); // deletando a adoção o pet não estará mais adotado.
        adocaoRepository.deleteById(id);





    }
}


