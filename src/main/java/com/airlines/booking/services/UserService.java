package com.airlines.booking.services;


import com.airlines.booking.payloads.ApiResponse;
import com.airlines.booking.payloads.UserDto;

import java.util.List;

public interface UserService {
    ApiResponse createUser(UserDto user);
    ApiResponse updateUser(UserDto userDto, String email);
    ApiResponse getUserById(String email);
    ApiResponse getAllUser();
    ApiResponse deleteUser(UserDto userDto, String email);
}
