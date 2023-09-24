package com.airlines.booking.payloads;

import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ApiResponse {
    private JsonObject response;
    private boolean success;
}

