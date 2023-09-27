package com.airlines.booking.exceptions;

public class DatabaseException extends RetryableException {
    public DatabaseException(String message){
        super(message);
    }
    public DatabaseException(Throwable cause){
        super(cause);
    }
    public DatabaseException(String message, Throwable cause){
        super(message, cause);
    }
}
