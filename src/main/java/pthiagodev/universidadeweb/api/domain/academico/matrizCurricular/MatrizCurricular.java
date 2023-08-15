package pthiagodev.universidadeweb.api.domain.academico.matrizCurricular;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pthiagodev.universidadeweb.api.domain.academico.curso.Curso;
import pthiagodev.universidadeweb.api.domain.academico.semestre.Semestre;

import java.util.List;

@Table(name = "matriz_curricular")
@Entity(name= "MatrizCurricular")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class MatrizCurricular {

    @Id
    private Long id;
    private String codigo;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private Curso curso;

    @OneToMany(mappedBy = "matrizCurricular", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Semestre> semestres;

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void adicionaSemestre(Semestre semestre) {
        semestres.add(semestre);
        semestre.setMatrizCurricular(this);
    }

    public void removeSemestre(Semestre semestre) {
        semestres.remove(semestre);
        semestre.setMatrizCurricular(null);
    }
}
