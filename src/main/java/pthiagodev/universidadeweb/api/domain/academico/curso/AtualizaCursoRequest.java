package pthiagodev.universidadeweb.api.domain.academico.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record AtualizaCursoRequest(
        @Positive(message = "Id deve ser maior que 0.")
        Long id,
        @NotBlank(message = "Nome é obrigatório.")
        String nome) {
}
