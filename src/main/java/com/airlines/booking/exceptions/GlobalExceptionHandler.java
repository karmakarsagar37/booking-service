package com.airlines.booking.exceptions;

import com.airlines.booking.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.airlines.booking.contants.ApiUtils.getApiResponseWhenException;

@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DatabaseException.class)
    ResponseEntity<ApiResponse> databaseExceptionHandler(DatabaseException ex) {
        ApiResponse apiResponse = getApiResponseWhenException(ex);
        return new ResponseEntity<ApiResponse>(apiResponse , HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(NonRetryableException.class)
    ResponseEntity<ApiResponse> nonRetryableExceptionHandler(NonRetryableException ex) {
        ApiResponse apiResponse = getApiResponseWhenException(ex);
        return new ResponseEntity<ApiResponse>(apiResponse , HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<ApiResponse> notFoundExceptionHandler(NotFoundException ex) {
        ApiResponse apiResponse = getApiResponseWhenException(ex);
        return new ResponseEntity<ApiResponse>(apiResponse , HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceAlreadyExists.class)
    ResponseEntity<ApiResponse> resourceAlreadyExistsHandler(ResourceAlreadyExists ex) {
        ApiResponse apiResponse = getApiResponseWhenException(ex);
        return new ResponseEntity<ApiResponse>(apiResponse , HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ApiResponse> resourceNotFoundHandler(ResourceNotFoundException ex) {
        ApiResponse apiResponse = getApiResponseWhenException(ex);
        return new ResponseEntity<ApiResponse>(apiResponse , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RetryableException.class)
    ResponseEntity<ApiResponse> retryableExceptionHandler(RetryableException ex) {
        String message = ex.getMessage();
        ApiResponse apiResponse = getApiResponseWhenException(ex);
        return new ResponseEntity<ApiResponse>(apiResponse , HttpStatus.SERVICE_UNAVAILABLE);
    }


}
