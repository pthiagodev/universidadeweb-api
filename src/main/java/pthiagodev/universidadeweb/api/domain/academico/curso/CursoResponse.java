package pthiagodev.universidadeweb.api.domain.academico.curso;

public record CursoResponse(Long id, String nome, String codigo) {

    public CursoResponse(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getCodigo());
    }
}
