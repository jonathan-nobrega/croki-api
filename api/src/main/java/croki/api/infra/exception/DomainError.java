package croki.api.infra.exception;

import croki.api.infra.exception.dto.RestErrorDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DomainError {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> notFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValid(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors().stream().map(ValidationErrorData::new);
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler({PropertyReferenceException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<RestErrorDTO> propertiesNotValid(Exception ex) {
        var status = HttpStatus.BAD_REQUEST;
        var error = new RestErrorDTO(status, ex.getLocalizedMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationError(ValidationException ex) {
        var error = new RestErrorDTO(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    private record ValidationErrorData(String field, String message) {
        public ValidationErrorData(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
