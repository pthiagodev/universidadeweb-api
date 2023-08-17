package pthiagodev.universidadeweb.api.domain.academico.semestre;

import org.springframework.stereotype.Service;
import pthiagodev.universidadeweb.api.domain.academico.disciplina.DisciplinaRepository;
import pthiagodev.universidadeweb.api.domain.academico.matrizcurricular.MatrizCurricularRepository;

import java.util.List;

@Service
public class SemestreService {

    private final SemestreRepository semestreRepository;
    private final MatrizCurricularRepository matrizCurricularRepository;

    private final DisciplinaRepository disciplinaRepository;

    public SemestreService(SemestreRepository semestreRepository, MatrizCurricularRepository matrizCurricularRepository, DisciplinaRepository disciplinaRepository) {
        this.semestreRepository = semestreRepository;
        this.matrizCurricularRepository = matrizCurricularRepository;
        this.disciplinaRepository = disciplinaRepository;
    }

    public Semestre busca(Long id) {
        return semestreRepository.getReferenceById(id);
    }

    public List<Semestre> lista() {
        return semestreRepository.findAll();
    }

    public List<Semestre> listaSemestresDoCurso(Long id) {
        return semestreRepository.findAllByMatrizCurricularId(id);
    }

    public Semestre cadastra(SemestreRequest dados) {
        var semestre = new Semestre(dados);
        semestre.setMatrizCurricular(matrizCurricularRepository.findByCodigo(dados.codMatriz()));

        return semestreRepository.save(semestre);
    }
}
