package com.airlines.booking.contants;

import com.airlines.booking.payloads.ApiResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.airlines.booking.contants.DbConstants.GSON;

@UtilityClass
public class ApiUtils {
    public static ApiResponse getApiResponseWhenException(@NotNull Throwable e) {
        Map<String, JsonArray> res = new HashMap<>();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("message", e.getMessage());
        jsonObject.addProperty("stackTrace", GSON.toJson(e.getStackTrace()));
        return ApiResponse.builder()
                .response(jsonObject)
                .success(false)
                .build();
    }
}
