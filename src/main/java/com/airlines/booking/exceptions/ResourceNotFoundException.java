package com.airlines.booking.exceptions;

import lombok.Builder;
import lombok.Value;

//@NoArgsConstructor
@Builder
@Value
public class ResourceNotFoundException extends RuntimeException {
    String resourceName;
    String fieldName;
    long fieldValue;
}
