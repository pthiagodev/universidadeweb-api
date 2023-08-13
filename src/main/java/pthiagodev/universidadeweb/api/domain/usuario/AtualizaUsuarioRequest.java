package pthiagodev.universidadeweb.api.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record AtualizaUsuarioRequest(
        @Positive(message = "Id deve ser maior que 0.")
        Long id,
        @NotBlank(message = "Login é obrigatório.")
        String login,
        @NotBlank(message = "Senha é obrigatória.")
        String senha) {

}
