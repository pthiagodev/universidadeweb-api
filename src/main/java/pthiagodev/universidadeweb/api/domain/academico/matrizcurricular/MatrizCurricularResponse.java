package pthiagodev.universidadeweb.api.domain.academico.matrizcurricular;

import pthiagodev.universidadeweb.api.domain.academico.curso.Curso;

public record MatrizCurricularResponse(Long id, String codigo, String codCurso) {
    public MatrizCurricularResponse(MatrizCurricular matriz){
        this(matriz.getId(), matriz.getCodigo(), matriz.getCurso().getCodigo());
    }
}
