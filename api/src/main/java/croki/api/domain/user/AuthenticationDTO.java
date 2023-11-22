package croki.api.domain.user;

public record AuthenticationDTO(
        String login,
        String password
) {
}
