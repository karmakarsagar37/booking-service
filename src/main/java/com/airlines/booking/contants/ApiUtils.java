package com.airlines.booking.contants;

import com.airlines.booking.payloads.ApiResponse;
import com.airlines.booking.payloads.ApiResponseWhenException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.airlines.booking.contants.DbConstants.GSON;

@UtilityClass
public class ApiUtils {
    public static ApiResponse getApiResponseWhenException(Throwable e) {
        Map<String, JsonArray> res = new HashMap<>();
        ApiResponseWhenException apiResponseWhenException= ApiResponseWhenException.builder()
                .message(e.getMessage())
                .stackTrace(Arrays.stream(e.getStackTrace()).collect(Collectors.toList()).toString())
                .build();
        return ApiResponse.builder()
                .response(GSON.toJsonTree(apiResponseWhenException).getAsJsonObject())
                .success(false)
                .build();
    }
}
