package pthiagodev.universidadeweb.api.domain.academico.curso;

import jakarta.validation.constraints.NotBlank;

public record CursoRequest(
        @NotBlank(message = "Nome é obrigatório.")
        String nome,

        @NotBlank(message = "Código é obrigatório.")
        String codigo) {
}
