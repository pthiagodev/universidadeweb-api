package pthiagodev.universidadeweb.api.domain.academico.semestre;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;
import pthiagodev.universidadeweb.api.domain.academico.disciplina.Disciplina;
import pthiagodev.universidadeweb.api.domain.academico.matrizcurricular.MatrizCurricular;

import java.util.HashSet;
import java.util.Set;

@Table(name = "semestres")
@Entity(name= "Semestre")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class Semestre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    private String codigo;

    @ManyToOne(fetch = FetchType.LAZY)
    private MatrizCurricular matrizCurricular;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "semestre_disciplinas",
        joinColumns = @JoinColumn(name = "semestres_id"),
        inverseJoinColumns = @JoinColumn(name = "disciplinas_id")
    )
    private Set<Disciplina> disciplinas = new HashSet<>();

    public void setMatrizCurricular(MatrizCurricular matriz) {
        this.matrizCurricular = matriz;
    }

    public void adicionaDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
        disciplina.getSemestres().add(this);
    }

    public void removeDisciplina(Disciplina disciplina) {
        disciplinas.remove(disciplina);
        disciplina.getSemestres().remove(this);
    }

}
