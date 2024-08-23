package dev.app.devreilway.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalException {
    private final Logger logger =  LoggerFactory.getLogger(GlobalException.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegal(IllegalArgumentException Illegal)    {
        return new ResponseEntity<>(Illegal.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFound(NoSuchElementException notFound)    {
        return new ResponseEntity<>("Reseruce ID not found",HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedExcepton(Throwable unexpectedExcepton)    {

        logger.error("UnexpectedExcepton, see the logs: ",unexpectedExcepton);
        return new ResponseEntity<>("Unexpected Server Erro ",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
