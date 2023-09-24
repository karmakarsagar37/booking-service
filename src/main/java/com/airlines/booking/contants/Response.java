package com.airlines.booking.contants;

import lombok.Builder;

import java.util.List;

@Builder
public class Response<T> {
    private T singleObject;
    private List<T> objectList;
}
