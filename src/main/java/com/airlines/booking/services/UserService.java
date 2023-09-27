package com.airlines.booking.services;


import com.airlines.booking.payloads.ApiResponse;
import com.airlines.booking.payloads.UserDto;

import java.util.List;

public interface UserService {
    ApiResponse createUser(UserDto user);
    ApiResponse updateUser(UserDto userDto , Integer userId);
    ApiResponse getUserById(String email);
    ApiResponse getAllUser();
    void deleteUser(Integer userId);
}
