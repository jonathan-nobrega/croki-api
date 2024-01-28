package croki.api.infra.exception;

import croki.api.infra.exception.dto.RestErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ServerGenericError {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestErrorDTO> error500(Exception ex) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR;
        var error = new RestErrorDTO(status, ex.getMessage());
        return ResponseEntity
                .status(status)
                .body(error);
    }
}
