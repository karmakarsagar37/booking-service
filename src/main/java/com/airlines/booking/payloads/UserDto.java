package com.airlines.booking.payloads;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {
    private String name;
    private String email;
    private String password;
    private String about;

}
