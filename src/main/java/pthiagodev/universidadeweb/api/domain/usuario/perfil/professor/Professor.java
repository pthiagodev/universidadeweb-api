package pthiagodev.universidadeweb.api.domain.usuario.perfil.professor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pthiagodev.universidadeweb.api.domain.academico.disciplina.Disciplina;


@Table(name = "professores")
@Entity(name= "Professor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

}
