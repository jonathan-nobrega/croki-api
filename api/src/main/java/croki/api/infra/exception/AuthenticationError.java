package croki.api.infra.exception;

import croki.api.infra.exception.dto.RestErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;
import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class AuthenticationError {

    @ExceptionHandler({BadCredentialsException.class, InternalAuthenticationServiceException.class})
    public ResponseEntity<RestErrorDTO> badCredentialsError() {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(new RestErrorDTO(HttpStatus.UNAUTHORIZED, "Invalid credentials"));
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<RestErrorDTO> authenticationGenericError() {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(new RestErrorDTO(HttpStatus.UNAUTHORIZED, "Authentication failed"));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<RestErrorDTO> accessDeniedError() {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(new RestErrorDTO(HttpStatus.FORBIDDEN, "Access denied"));
    }

}
