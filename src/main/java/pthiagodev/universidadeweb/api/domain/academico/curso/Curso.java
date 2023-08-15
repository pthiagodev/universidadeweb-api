package pthiagodev.universidadeweb.api.domain.academico.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pthiagodev.universidadeweb.api.domain.academico.matrizCurricular.MatrizCurricular;

import java.util.List;

@Table(name = "cursos")
@Entity(name= "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String codigo;

    @OneToOne(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private MatrizCurricular matrizCurricular;

    public Curso(CursoRequest curso) {
        this.nome = curso.nome();
        this.codigo = curso.codigo();
    }

    public void setMatrizCurricular(MatrizCurricular matriz) {
        if (matriz == null) {
            if (this.matrizCurricular != null)
                this.matrizCurricular.setCurso(null);
        } else {
            matriz.setCurso(this);
        }
        this.matrizCurricular = matriz;
    }

    public void atualiza(AtualizaCursoRequest dados) {
        this.nome = dados.nome();
    }

}
