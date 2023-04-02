package ru.netology.courseprojectmoneytransfer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> errorInputData(ErrorInputData errorInputData) {
        return new ResponseEntity<>(errorInputData.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> errorTransfer(ErrorTransfer errorTransfer) {
        return new ResponseEntity<>(errorTransfer.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<String> errorConfirmation(ErrorConfirmation errorConfirmation) {
        return new ResponseEntity<>(errorConfirmation.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}