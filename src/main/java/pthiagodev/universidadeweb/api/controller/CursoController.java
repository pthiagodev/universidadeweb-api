package pthiagodev.universidadeweb.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pthiagodev.universidadeweb.api.domain.academico.curso.*;

import java.util.stream.Stream;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoRepository repository;

    public CursoController(CursoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("{id}")
    public ResponseEntity buscar(@PathVariable Long id) {
        var curso = repository.getReferenceById(id);

        return ResponseEntity.ok(new CursoResponse(curso));
    }

    @GetMapping
    public ResponseEntity<Stream<CursoResponse>> listar() {
        Stream<CursoResponse> cursos = repository.findAll().stream().map(CursoResponse::new);
        return ResponseEntity.ok(cursos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody CursoRequest dados, UriComponentsBuilder uriBuilder) {
        var curso = new Curso(dados);
        repository.save(curso);

        var uri = uriBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(uri).body(new CursoResponse(curso));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizaCursoRequest dados) {
        var curso = repository.getReferenceById(dados.id());
        curso.atualiza(dados);

        return ResponseEntity.ok(new CursoResponse(curso));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
