package pthiagodev.universidadeweb.api.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRequest(
        @NotBlank(message = "Login é obrigatório.")
        String login,
        @NotBlank(message = "Senha é obrigatória.")
        String senha) {
}
