package pthiagodev.universidadeweb.api.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pthiagodev.universidadeweb.api.domain.usuario.AutenticacaoRequest;
import pthiagodev.universidadeweb.api.domain.usuario.Usuario;
import pthiagodev.universidadeweb.api.infra.security.TokenJWTResponse;
import pthiagodev.universidadeweb.api.infra.security.TokenService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    private final AuthenticationManager manager;

    private final TokenService tokenService;

    public AutenticacaoController(AuthenticationManager manager, TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid AutenticacaoRequest autenticacao) {

        var authToken = new UsernamePasswordAuthenticationToken(autenticacao.login(), autenticacao.senha());
        var authentication = manager.authenticate(authToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenJWTResponse(tokenJWT));
    }
}
