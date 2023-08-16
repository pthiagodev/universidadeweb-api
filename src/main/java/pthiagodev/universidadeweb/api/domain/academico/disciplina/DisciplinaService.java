package pthiagodev.universidadeweb.api.domain.academico.disciplina;

import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public Disciplina cadastra(DisciplinaRequest dados) {
        var disciplina = new Disciplina(dados);

        return disciplinaRepository.save(disciplina);
    }

    public Disciplina busca(Long id) {
        return disciplinaRepository.getReferenceById(id);
    }
}
