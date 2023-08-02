package com.izibiz.edonusum.invoicemanager.exception;

import lombok.Data;

@Data
public class InvalidInfoException extends RuntimeException {

    public InvalidInfoException(String message){
        super(message);
    }

    public InvalidInfoException(String message, Throwable cause){
        super(message, cause);
    }

}
