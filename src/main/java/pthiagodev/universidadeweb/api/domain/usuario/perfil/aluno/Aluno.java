package pthiagodev.universidadeweb.api.domain.usuario.perfil.aluno;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pthiagodev.universidadeweb.api.domain.academico.curso.Curso;

@Table(name = "alunos")
@Entity(name= "Aluno")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String matricula;

    @OneToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

}
