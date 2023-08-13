package pthiagodev.universidadeweb.api.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRequest(@NotBlank String login, @NotBlank String senha) {
}
