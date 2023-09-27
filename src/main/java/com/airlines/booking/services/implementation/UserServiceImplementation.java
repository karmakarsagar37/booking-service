package com.airlines.booking.services.implementation;

import com.airlines.booking.dao.UserDao;
import com.airlines.booking.models.User;
import com.airlines.booking.payloads.ApiResponse;
import com.airlines.booking.payloads.UserDto;
import com.airlines.booking.services.UserService;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Objects;

import static com.airlines.booking.contants.DbConstants.GSON;
import static com.airlines.booking.contants.DbConstants.USER_COLLECTION;

@AllArgsConstructor
public class UserServiceImplementation implements UserService {
    private ModelMapper modelMapper;
    private UserDao userDao;


    @Override
    public ApiResponse createUser(UserDto userDto) {
        ApiResponse apiResponse;
        User user = userDao.createUser(this.modelMapper.map(userDto , User.class));
        JsonObject res =  new JsonObject();
        res.add(USER_COLLECTION, GSON.toJsonTree(user));
        apiResponse = ApiResponse.builder()
                .success(true)
                .response(res)
                .build();

        return apiResponse;

    }

    @Override
    public ApiResponse getAllUser() {
        List<User> users = this.userDao.getAllUserDetails();
        System.out.println("[GetAllUser]" + users.toString());
        JsonObject res =  new JsonObject();
        res.add(USER_COLLECTION, GSON.toJsonTree(users));
        return ApiResponse.builder()
                .success(true)
                .response(res)
                .build();
    }

    @Override
    public ApiResponse updateUser(UserDto userDto, String email) {
        User user = this.userDao.updateUserDetails(this.modelMapper.map(userDto , User.class), email);
        JsonObject res =  new JsonObject();
        res.add(USER_COLLECTION, GSON.toJsonTree(user));
        return ApiResponse.builder()
                .success(true)
                .response(res)
                .build();
    }

    @Override
    public ApiResponse getUserById(String email) {
        User user = this.userDao.getUserDetails(email);
        JsonObject res =  new JsonObject();
        res.add(USER_COLLECTION, GSON.toJsonTree(user));
        return ApiResponse.builder()
                .success(true)
                .response(res)
                .build();
    }



    @Override
    public ApiResponse deleteUser(UserDto userDto, String email) {
        if(this.userDao.deleteUser(this.modelMapper.map(userDto , User.class), email)) {
            return ApiResponse.builder()
                    .success(true)
                    .build();
        } else {
            return ApiResponse.builder()
                    .success(false)
                    .build();
        }

    }

    private JsonObject prepareApiResponse(Objects user) {
        JsonObject res =  new JsonObject();
        res.add(USER_COLLECTION, GSON.toJsonTree(user));
        return res;
    }
}
