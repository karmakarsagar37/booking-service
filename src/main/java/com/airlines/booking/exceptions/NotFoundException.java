package com.airlines.booking.exceptions;

public class NotFoundException extends NonRetryableException{
    public NotFoundException(String message){
        super(message);
    }
    public NotFoundException(Throwable cause){
        super(cause);
    }
    public NotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
