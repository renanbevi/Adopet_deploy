package br.com.alura.challange.Adopet.Controller;

import br.com.alura.challange.Adopet.Domain.Usuario.DadosAutenticacao;
import br.com.alura.challange.Adopet.Domain.Usuario.Usuario;
import br.com.alura.challange.Adopet.Domain.Usuario.UsuarioRepository;
import br.com.alura.challange.Adopet.Infra.security.TokenService;
import br.com.alura.challange.Adopet.Infra.security.DadosTokenJWT;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
   private AuthenticationManager manager;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        var Authenticationtoken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication =   manager.authenticate(Authenticationtoken); //converte do dto para o token

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return  ResponseEntity.ok(new DadosTokenJWT(tokenJWT)); //getprincipal pega o usuario logado

        //usuarioRepository.save(new Usuario(dados));
        //return ResponseEntity.ok("Usuario cadastrado com sucesso");



    }
}
