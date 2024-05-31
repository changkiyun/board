package hello.board.advice;

import hello.board.exception.NotFoundIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<String> notFoundIdException(NotFoundIdException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
