package pthiagodev.universidadeweb.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pthiagodev.universidadeweb.api.domain.academico.matrizcurricular.*;

import java.util.stream.Stream;

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

    @GetMapping
    public ResponseEntity<Stream<MatrizCurricularResponse>> listar() {
        Stream<MatrizCurricularResponse> matrizes = matrizCurricularService.lista().stream().map(MatrizCurricularResponse::new);
        return ResponseEntity.ok(matrizes);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody MatrizCurricularRequest dados, UriComponentsBuilder uriBuilder) {
        var matriz = matrizCurricularService.cadastra(dados);
        var uri = uriBuilder.path("/matriz-curricular/{id}").buildAndExpand(matriz.getId()).toUri();

        return ResponseEntity.created(uri).body(new MatrizCurricularResponse(matriz));
    }

    @PutMapping("{id}/semestres")
    @Transactional
    public ResponseEntity atualizarSemestres(@RequestBody @Valid AtualizaSemestresMatrizRequest dados) {
        return ResponseEntity.ok(new MatrizCurricularResponse(matrizCurricularService.atualizaSemestres(dados)));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        matrizCurricularService.exclui(id);

        return ResponseEntity.noContent().build();
    }

}
