package com.airlines.booking.contants;

import com.google.gson.Gson;

public final class DbConstants {
    public static final String MONGODB_URL=System.getProperty("spring.data.mongodb.uri");
    public static final Gson GSON = new Gson();
    public static final String USER_COLLECTION="user";
}
