package pthiagodev.universidadeweb.api.domain.academico.matrizcurricular;

import org.springframework.stereotype.Service;
import pthiagodev.universidadeweb.api.domain.academico.curso.CursoRepository;

@Service
public class MatrizCurricularService {

    private final MatrizCurricularRepository matrizCurricularRepository;
    private final CursoRepository cursoRepository;

    public MatrizCurricularService(MatrizCurricularRepository matrizCurricularRepository, CursoRepository cursoRepository) {
        this.matrizCurricularRepository = matrizCurricularRepository;
        this.cursoRepository = cursoRepository;
    }

    public MatrizCurricular busca(Long id) {
        return matrizCurricularRepository.getReferenceById(id);
    }

    public MatrizCurricular cadastra(MatrizCurricularRequest dados) {
        var matriz = new MatrizCurricular(dados);
        var curso = cursoRepository.getReferenceById(dados.idCurso());
        curso.setMatrizCurricular(matriz);

        return matrizCurricularRepository.save(matriz);
    }

}
