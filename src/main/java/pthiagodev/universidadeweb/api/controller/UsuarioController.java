package pthiagodev.universidadeweb.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pthiagodev.universidadeweb.api.domain.usuario.*;
import java.util.stream.Stream;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping("{id}")
    public ResponseEntity buscar(@PathVariable Long id) {
        var usuario = repository.getReferenceById(id);

        return ResponseEntity.ok(new UsuarioResponse(usuario));
    }

    @GetMapping
    public ResponseEntity<Stream<UsuarioResponse>> listarAtivos() {
        Stream<UsuarioResponse> usuarios = repository.findAllByAtivoTrue().stream().map(UsuarioResponse::new);
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody UsuarioRequest dados, UriComponentsBuilder uriBuilder) {
        var usuario = new Usuario(dados);
        repository.save(usuario);

        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new UsuarioResponse(usuario));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizaUsuarioRequest dados) {
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualiza(dados);

        return ResponseEntity.ok(new UsuarioResponse(usuario));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var usuario = repository.getReferenceById(id);
        usuario.excluir();

        return ResponseEntity.noContent().build();
    }
}
