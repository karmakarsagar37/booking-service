package com.airlines.booking.contants;

import com.airlines.booking.payloads.ApiResponse;
import com.google.gson.JsonObject;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class ApiUtils {
    public static ApiResponse getApiResponseWhenException(@NotNull Throwable e) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("message", e.getMessage());
        jsonObject.addProperty("stackTrace", e.toString());
        return ApiResponse.builder()
                .response(jsonObject)
                .success(false)
                .build();
    }
}
