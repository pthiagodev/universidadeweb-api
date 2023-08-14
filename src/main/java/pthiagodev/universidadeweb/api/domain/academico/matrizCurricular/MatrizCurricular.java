package pthiagodev.universidadeweb.api.domain.academico.matrizCurricular;

import pthiagodev.universidadeweb.api.domain.academico.curso.Curso;
import pthiagodev.universidadeweb.api.domain.academico.semestre.Semestre;

import java.util.List;

public class MatrizCurricular {

    private Long id;
    private String codigo;
    private Curso curso;
    private List<Semestre> semestres;
}
