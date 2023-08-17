package pthiagodev.universidadeweb.api.domain.academico.semestre;

import pthiagodev.universidadeweb.api.domain.academico.disciplina.Disciplina;

import java.util.List;

public record SemestreRequest(String codigo, String codMatriz, List<Disciplina> disciplinas) {
}
