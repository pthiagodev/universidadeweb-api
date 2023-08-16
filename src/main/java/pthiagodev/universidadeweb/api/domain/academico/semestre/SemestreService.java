package pthiagodev.universidadeweb.api.domain.academico.semestre;

import org.springframework.stereotype.Service;

@Service
public class SemestreService {

    private final SemestreRepository semestreRepository;

    public SemestreService(SemestreRepository semestreRepository) {
        this.semestreRepository = semestreRepository;
    }

    public Semestre busca(Long id) {
        return semestreRepository.getReferenceById(id);
    }
}
