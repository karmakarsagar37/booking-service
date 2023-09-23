package com.airlines.booking.payloads;

import lombok.Builder;

@Builder
public class ApiResponseWhenException {
    String message;
    String stackTrace;
}
