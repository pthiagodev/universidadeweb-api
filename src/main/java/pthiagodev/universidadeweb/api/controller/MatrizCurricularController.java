package pthiagodev.universidadeweb.api.controller;

import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pthiagodev.universidadeweb.api.domain.academico.matrizcurricular.*;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/matriz-curricular")
public class MatrizCurricularController {

    private final MatrizCurricularService matrizCurricularService;

    public MatrizCurricularController(MatrizCurricularService matrizCurricularService) {
        this.matrizCurricularService = matrizCurricularService;
    }

    @GetMapping("{id}")
    public ResponseEntity buscar(@PathVariable Long id) {
        var matriz = matrizCurricularService.busca(id);

        return ResponseEntity.ok(new MatrizCurricularResponse(matriz));
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody MatrizCurricularRequest dados, UriComponentsBuilder uriBuilder) {
        var matriz = matrizCurricularService.cadastra(dados);
        var uri = uriBuilder.path("/matriz-curricular/{id}").buildAndExpand(matriz.getId()).toUri();

        return ResponseEntity.created(uri).body(new MatrizCurricularResponse(matriz));
    }

}
