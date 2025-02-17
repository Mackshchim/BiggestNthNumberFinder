package tatar.mackshchim.ftbn.findthebiggestnincolumn.aspects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tatar.mackshchim.ftbn.findthebiggestnincolumn.dto.ExceptionDto;

@ControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> handleNotFound(RuntimeException e) {
        return buildResponseEntity(HttpStatus.NOT_FOUND, e);
    }


    private ResponseEntity<ExceptionDto> buildResponseEntity(HttpStatus status, Exception e) {
        return ResponseEntity.status(status)
                .body(ExceptionDto.builder()
                        .message(e.getMessage())
                        .status(status.value())
                        .build());
    }

}
