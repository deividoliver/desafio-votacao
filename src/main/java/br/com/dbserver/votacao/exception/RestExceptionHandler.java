package br.com.dbserver.votacao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(VotacaoException.class)
    private ResponseEntity<RestErroMessage> eventExceptionHandler(VotacaoException exception) {
        RestErroMessage breakResponse = new RestErroMessage(HttpStatus.BAD_REQUEST, exception.getMensagem());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(breakResponse);
    }

    @ExceptionHandler(NaoEncontradoException.class)
    private ResponseEntity<RestErroMessage> eventExceptionHandler(NaoEncontradoException exception) {
        RestErroMessage breakResponse = new RestErroMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(breakResponse);
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<RestErroMessage> eventExceptionHandler(Exception exception) {
        RestErroMessage breakResponse = new RestErroMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(breakResponse);
    }

}
