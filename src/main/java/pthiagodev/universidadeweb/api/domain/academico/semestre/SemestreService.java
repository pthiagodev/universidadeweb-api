package pthiagodev.universidadeweb.api.domain.academico.semestre;

import org.springframework.stereotype.Service;
import pthiagodev.universidadeweb.api.domain.academico.disciplina.Disciplina;
import pthiagodev.universidadeweb.api.domain.academico.matrizcurricular.MatrizCurricularRepository;

import java.util.List;

@Service
public class SemestreService {

    private final SemestreRepository semestreRepository;
    private final MatrizCurricularRepository matrizCurricularRepository;

    public SemestreService(SemestreRepository semestreRepository, MatrizCurricularRepository matrizCurricularRepository) {
        this.semestreRepository = semestreRepository;
        this.matrizCurricularRepository = matrizCurricularRepository;
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
        var disciplinas = dados.disciplinas();

        if (!disciplinas.isEmpty()) {
            for (Disciplina d : disciplinas)
                semestre.adicionaDisciplina(d);
        }

        return semestre;
    }
}
