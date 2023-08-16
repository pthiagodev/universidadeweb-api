package pthiagodev.universidadeweb.api.domain.academico.curso;

public record CursoResponse(Long id, String nome, String codigo, String codMatriz) {

    public CursoResponse(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getCodigo(), curso.getMatrizCurricular().getCodigo());
    }
}
