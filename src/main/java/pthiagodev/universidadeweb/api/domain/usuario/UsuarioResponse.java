package pthiagodev.universidadeweb.api.domain.usuario;

public record UsuarioResponse(Long id, String login) {
    public UsuarioResponse(Usuario usuario) {
        this(usuario.getId(), usuario.getLogin());
    }
}
