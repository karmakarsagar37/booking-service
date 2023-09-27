package com.airlines.booking.exceptions;

public class ResourceAlreadyExists extends NonRetryableException{
    public ResourceAlreadyExists(String message){
        super(message);
    }
    public ResourceAlreadyExists(Throwable cause){
        super(cause);
    }
    public ResourceAlreadyExists(String message, Throwable cause){
        super(message, cause);
    }
}
