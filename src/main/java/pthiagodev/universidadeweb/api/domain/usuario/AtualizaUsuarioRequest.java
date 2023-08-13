package pthiagodev.universidadeweb.api.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record AtualizaUsuarioRequest(@Positive Long id, @NotBlank String login, @NotBlank String senha) {
}
