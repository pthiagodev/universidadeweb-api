package pthiagodev.universidadeweb.api.domain.academico.semestre;

import pthiagodev.universidadeweb.api.domain.academico.disciplina.Disciplina;

import java.util.List;
import java.util.Set;

public record SemestreResponse(Long id, String codigo, String codMatriz, Set<Disciplina> disciplinas) {
    public SemestreResponse(Semestre semestre) {
        this(semestre.getId(), semestre.getCodigo(), semestre.getMatrizCurricular().getCodigo(), semestre.getDisciplinas());
    }
}
