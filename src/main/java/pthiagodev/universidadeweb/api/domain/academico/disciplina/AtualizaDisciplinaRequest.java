package pthiagodev.universidadeweb.api.domain.academico.disciplina;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record AtualizaDisciplinaRequest(
        @Positive(message = "Id deve ser maior que 0.")
        Long id,
        @NotBlank(message = "Nome é obrigatório.")
        String nome,

        @Positive
        int cargaHoraria) {
}
