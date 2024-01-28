package croki.api.infra.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

public record RestErrorDTO(HttpStatus status, String message) {

    public RestErrorDTO(RestError error) {
        this(error.getStatus(), error.getMessage());
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class RestError {
        private HttpStatus status;
        private String message;
    }
}
