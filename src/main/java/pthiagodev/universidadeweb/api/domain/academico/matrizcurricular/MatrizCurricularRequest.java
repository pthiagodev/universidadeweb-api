package pthiagodev.universidadeweb.api.domain.academico.matrizcurricular;

import pthiagodev.universidadeweb.api.domain.academico.curso.Curso;

public record MatrizCurricularRequest(String codigo, Long idCurso) {
}
