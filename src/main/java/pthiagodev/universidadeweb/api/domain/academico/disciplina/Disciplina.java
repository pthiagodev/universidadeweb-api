package pthiagodev.universidadeweb.api.domain.academico.disciplina;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;
import pthiagodev.universidadeweb.api.domain.academico.semestre.Semestre;

import java.util.HashSet;
import java.util.Set;

@Table(name = "disciplinas")
@Entity(name= "Disciplina")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @NaturalId
    private String codigo;
    private int cargaHoraria;

    @ManyToMany(mappedBy = "disciplinas")
    private Set<Semestre> semestres = new HashSet<>();

    public Disciplina(DisciplinaRequest dados) {
        this.nome = dados.nome();
        this.codigo = dados.codigo();
        this.cargaHoraria = dados.cargaHoraria();
    }
}
