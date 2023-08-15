package pthiagodev.universidadeweb.api.domain.academico.disciplina;

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

}
