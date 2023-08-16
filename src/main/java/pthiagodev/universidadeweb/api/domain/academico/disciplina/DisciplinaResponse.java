package pthiagodev.universidadeweb.api.domain.academico.disciplina;

public record DisciplinaResponse(Long id, String nome, String codigo, int cargaHoraria) {

    public DisciplinaResponse(Disciplina disciplina) {
        this(disciplina.getId(), disciplina.getNome(), disciplina.getCodigo(), disciplina.getCargaHoraria());
    }
}
