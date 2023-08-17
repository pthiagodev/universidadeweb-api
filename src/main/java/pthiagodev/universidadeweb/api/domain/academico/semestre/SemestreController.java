package pthiagodev.universidadeweb.api.domain.academico.semestre;

import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
