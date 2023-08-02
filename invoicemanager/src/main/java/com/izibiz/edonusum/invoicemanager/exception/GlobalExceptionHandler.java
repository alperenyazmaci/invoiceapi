package com.izibiz.edonusum.invoicemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.InvalidNameException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler( {InvalidInfoException.class} )
    public ResponseEntity<String> handleInvalidCustomerIdException(InvalidInfoException e){
        return new ResponseEntity<>(e.getMessage(), null, HttpStatus.BAD_REQUEST);
    }

}
