package croki.api.infra.exception;

import croki.api.infra.exception.dto.RestErrorDTO;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DatabaseError {

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Object> databaseError(DataAccessException ex) {
        var error = new RestErrorDTO(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
