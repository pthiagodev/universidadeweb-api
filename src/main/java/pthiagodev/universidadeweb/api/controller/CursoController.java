package pthiagodev.universidadeweb.api.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pthiagodev.universidadeweb.api.domain.academico.curso.Curso;
import pthiagodev.universidadeweb.api.domain.academico.curso.CursoRepository;
import pthiagodev.universidadeweb.api.domain.academico.curso.CursoRequest;
import pthiagodev.universidadeweb.api.domain.academico.curso.CursoResponse;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @GetMapping("{id}")
    public ResponseEntity buscar(@PathVariable Long id) {
        var curso = repository.getReferenceById(id);

        return ResponseEntity.ok(new CursoResponse(curso));
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody CursoRequest dados, UriComponentsBuilder uriBuilder) {
        var curso = new Curso(dados);
        repository.save(curso);

        var uri = uriBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(uri).body(new CursoResponse(curso));
    }
}
