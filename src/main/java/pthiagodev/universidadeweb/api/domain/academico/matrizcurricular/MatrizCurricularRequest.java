package pthiagodev.universidadeweb.api.domain.academico.matrizcurricular;

import pthiagodev.universidadeweb.api.domain.academico.semestre.Semestre;

import java.util.List;

public record MatrizCurricularRequest(String codigo, Long idCurso, List<Semestre> semestres) {
}
