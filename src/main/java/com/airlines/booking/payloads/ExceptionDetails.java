package com.airlines.booking.payloads;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ExceptionDetails {
    String message;
    String stackTrace;
}
