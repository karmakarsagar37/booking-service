package com.airlines.booking.exceptions;

import com.airlines.booking.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ApiResponse> resourceNotFoundHandler(ResourceNotFoundException ex) {
        String message = ex.getMessage();

        ApiResponse apiResponse = ApiResponse.builder()
                .success(false)
//                .response(ex.getMessage())
                .build();
        return new ResponseEntity<ApiResponse>(apiResponse , HttpStatus.NOT_FOUND);
    }
//    @ExceptionHandler(ResourceNotFoundException.class)
//    ResponseEntity<ApiResponse> resourceNotFoundHandler(ResourceNotFoundException ex) {
//        String message = ex.getMessage();
//        ApiResponse apiResponse = ApiResponse.builder()
//                .success(false)
////                .response(ex.getMessage())
//                .build();
//        return new ResponseEntity<ApiResponse>(apiResponse , HttpStatus.NOT_FOUND);
//    }
}
