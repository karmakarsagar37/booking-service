package com.airlines.booking.controllers;

import com.airlines.booking.payloads.ApiResponse;
import com.airlines.booking.payloads.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HealthCheck {
    @GetMapping("healthcheck")
    public ResponseEntity<ApiResponse> healthCheck() {
        return new ResponseEntity<ApiResponse>(ApiResponse.builder().success(true).build(), HttpStatus.OK);
    }
}
