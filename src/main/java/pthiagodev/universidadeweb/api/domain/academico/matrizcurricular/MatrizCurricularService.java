package pthiagodev.universidadeweb.api.domain.academico.matrizcurricular;

import org.springframework.stereotype.Service;
import pthiagodev.universidadeweb.api.domain.academico.curso.CursoRepository;
import pthiagodev.universidadeweb.api.domain.academico.semestre.Semestre;

import java.util.List;

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

    public List<MatrizCurricular> lista() {
        return matrizCurricularRepository.findAll();
    }

    public MatrizCurricular cadastra(MatrizCurricularRequest dados) {
        var matriz = new MatrizCurricular(dados);
        var curso = cursoRepository.getReferenceById(dados.idCurso());
        curso.setMatrizCurricular(matriz);

        if (dados.semestres() != null) {
            for (Semestre semestre : dados.semestres()) {
                matriz.adicionaSemestre(semestre);
            }
        }

        return matrizCurricularRepository.save(matriz);
    }

    public MatrizCurricular atualizaSemestres(AtualizaSemestresMatrizRequest dados) {
        var matriz = matrizCurricularRepository.getReferenceById(dados.id());
        var semestres = matriz.getSemestres();
        var semestresAtualizados = dados.semestres();

        for (Semestre semestre : semestres) {
            if (!semestresAtualizados.contains(semestre))
                matriz.removeSemestre(semestre);
        }

        for (Semestre semestreAtualizado : semestresAtualizados) {
            if (!semestres.contains(semestreAtualizado))
                matriz.adicionaSemestre(semestreAtualizado);
        }

        return matriz;
    }

    public void exclui(Long id) {
        var matriz = matrizCurricularRepository.getReferenceById(id);
        var curso = cursoRepository.getReferenceById(matriz.getId());
        curso.setMatrizCurricular(null);

        matrizCurricularRepository.delete(matriz);
    }
}
