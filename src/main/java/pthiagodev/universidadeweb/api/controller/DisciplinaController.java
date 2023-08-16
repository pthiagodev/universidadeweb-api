package pthiagodev.universidadeweb.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pthiagodev.universidadeweb.api.domain.academico.disciplina.DisciplinaRequest;
import pthiagodev.universidadeweb.api.domain.academico.disciplina.DisciplinaResponse;
import pthiagodev.universidadeweb.api.domain.academico.disciplina.DisciplinaService;

import java.util.stream.Stream;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @GetMapping("{id}")
    public ResponseEntity buscar(@PathVariable Long id) {
        var disciplina = disciplinaService.busca(id);

        return ResponseEntity.ok(new DisciplinaResponse(disciplina));
    }

    @GetMapping
    public ResponseEntity<Stream<DisciplinaResponse>> listar() {
        Stream<DisciplinaResponse> disciplinas = disciplinaService.lista().stream().map(DisciplinaResponse::new);
        return ResponseEntity.ok(disciplinas);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DisciplinaRequest dados, UriComponentsBuilder uriBuilder) {
        var disciplina = disciplinaService.cadastra(dados);
        var uri = uriBuilder.path("/disciplinas/{id}").buildAndExpand(disciplina.getId()).toUri();

        return ResponseEntity.created(uri).body(new DisciplinaResponse(disciplina));
    }

}
