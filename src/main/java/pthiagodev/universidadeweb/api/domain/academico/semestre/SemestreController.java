package pthiagodev.universidadeweb.api.domain.academico.semestre;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pthiagodev.universidadeweb.api.domain.academico.disciplina.DisciplinaResponse;

import java.util.stream.Stream;

@RestController
@RequestMapping("/semestres")
public class SemestreController {

    private final SemestreService semestreService;

    public SemestreController(SemestreService semestreService) {
        this.semestreService = semestreService;
    }

    @GetMapping("{id}")
    public ResponseEntity buscar(@PathVariable Long id) {
        var semestre = semestreService.busca(id);

        return ResponseEntity.ok(new SemestreResponse(semestre));
    }

    @GetMapping
    public ResponseEntity<Stream<SemestreResponse>> listar() {
        Stream<SemestreResponse> semestres = semestreService.lista().stream().map(SemestreResponse::new);
        return ResponseEntity.ok(semestres);
    }

    @GetMapping("{id}")
    public ResponseEntity<Stream<SemestreResponse>> listarSemestresDoCurso(@PathVariable Long id) {
      Stream<SemestreResponse> semestres = semestreService.listaSemestresPeloCurso(id).stream().map(SemestreResponse::new);
      return ResponseEntity.ok(semestres);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid SemestreRequest dados, UriComponentsBuilder uriBuilder) {
        var semestre = semestreService.cadastra(dados);
        var uri = uriBuilder.path("/semestres/{id}").buildAndExpand(semestre.getId()).toUri();

        return ResponseEntity.created(uri).body(new SemestreResponse(semestre));
    }

}
