package pthiagodev.universidadeweb.api.domain.academico.semestre;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class SemestreService {

    private final SemestreRepository semestreRepository;

    public SemestreService(SemestreRepository semestreRepository) {
        this.semestreRepository = semestreRepository;
    }

    public Semestre busca(Long id) {
        return semestreRepository.getReferenceById(id);
    }

    public List<Semestre> lista() {
        return semestreRepository.findAll();
    }

    public List<Semestre> listaSemestresPeloCurso(Long id) {
        return semestreRepository.findAllByMatrizCurricularId(id);
    }

    public Semestre cadastra(SemestreRequest dados) {

    }
}
