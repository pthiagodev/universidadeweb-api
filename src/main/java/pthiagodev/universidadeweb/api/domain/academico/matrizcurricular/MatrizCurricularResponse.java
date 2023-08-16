package pthiagodev.universidadeweb.api.domain.academico.matrizcurricular;

import pthiagodev.universidadeweb.api.domain.academico.semestre.Semestre;

import java.util.List;

public record MatrizCurricularResponse(Long id, String codigo, String codCurso, List<Semestre> semestres) {
    public MatrizCurricularResponse(MatrizCurricular matriz){
        this(matriz.getId(), matriz.getCodigo(), matriz.getCurso().getCodigo(), matriz.getSemestres());
    }
}
