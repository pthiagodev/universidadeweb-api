package pthiagodev.universidadeweb.api.domain.academico.disciplina;

import org.springframework.stereotype.Service;
import pthiagodev.universidadeweb.api.domain.academico.semestre.Semestre;

import java.util.List;
import java.util.stream.Stream;

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

    public List<Disciplina> lista() {
        return disciplinaRepository.findAll();
    }

    public Disciplina atualiza(AtualizaDisciplinaRequest dados) {
        var disciplina = disciplinaRepository.getReferenceById(dados.id());
        disciplina.atualiza(dados);

        return disciplina;
    }

    public void exclui(Long id) {
        var disciplina = disciplinaRepository.getReferenceById(id);
        var semestres = disciplina.getSemestres();

        if (!semestres.isEmpty()) {
            for (Semestre semestre : semestres)
                semestre.removeDisciplina(disciplina);
        }

        disciplinaRepository.delete(disciplina);
    }
}
