package pthiagodev.universidadeweb.api.domain.academico.semestre;

import pthiagodev.universidadeweb.api.domain.academico.disciplina.Disciplina;
import pthiagodev.universidadeweb.api.domain.academico.matrizCurricular.MatrizCurricular;

import java.util.List;

public class Semestre {

    private Long id;
    private String codigo;
    private MatrizCurricular matrizCurricular;
    List<Disciplina> disciplinas;
}
