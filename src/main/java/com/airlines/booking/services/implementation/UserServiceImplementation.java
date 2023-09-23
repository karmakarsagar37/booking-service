package com.airlines.booking.services.implementation;

import com.airlines.booking.dao.UserDao;
import com.airlines.booking.exceptions.ResourceNotFoundException;
import com.airlines.booking.models.Customer;
import com.airlines.booking.models.User;
import com.airlines.booking.payloads.ApiResponse;
import com.airlines.booking.payloads.UserDto;
import com.airlines.booking.repo.CustomerRepo;
import com.airlines.booking.repo.UserRepo;
import com.airlines.booking.services.UserService;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.airlines.booking.contants.ApiUtils.getApiResponseWhenException;
import static com.airlines.booking.contants.DbConstants.GSON;
import static com.airlines.booking.contants.DbConstants.MONGODB_URL;
import static com.airlines.booking.contants.DbConstants.USER_COLLECTION;

@AllArgsConstructor
public class UserServiceImplementation implements UserService {
    private ModelMapper modelMapper;
    private UserDao userDao;

    @Override
    public ApiResponse createUser(UserDto userDto) {
        ApiResponse apiResponse;
        System.out.println("[SERVICE]:" + userDto.toString());
        System.out.println("[SERVICE]: " + MONGODB_URL);
        try{
            User user = userDao.createUser(this.modelMapper.map(userDto , User.class));
            apiResponse = ApiResponse.builder()
                    .success(true)
                    .response(GSON.toJsonTree(user).getAsJsonObject())
                    .build();

            return apiResponse;
        } catch(Exception e){
            return getApiResponseWhenException(e);
        }
    }

    @Override
    public ApiResponse updateUser(UserDto userDto, Integer userId) {
//        User user=this.userRepo.findById(userId).orElseThrow( () -> ResourceNotFoundException
//                .builder()
//                .resourceName("User")
//                .fieldName(" id")
//                .fieldValue(userId)
//                .build());
//
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setAbout(userDto.getAbout());
//        user.setPassword(userDto.getPassword());
//
//        User updatedUser = this.userRepo.save(user);
//        UserDto userDto1 = this.userToDto(updatedUser);
        return ApiResponse.builder().build();
    }

    @Override
    public ApiResponse getUserById(Integer userId) {

//        User user=this.userRepo.findById(userId).orElseThrow( () -> ResourceNotFoundException
//                .builder()
//                .resourceName("User")
//                .fieldName(" id")
//                .fieldValue(userId)
//                .build());
        return ApiResponse.builder().build();
    }

    @Override
    public ApiResponse getAllUser() {
//        List<User> users= this.userRepo.findAll();
//        List<UserDto> userDtos = users.stream().map( user -> this.userToDto(user)).collect(Collectors.toList());

        return ApiResponse.builder().build();
    }

    @Override
    public void deleteUser(Integer userId) {
//        User user=this.userRepo.findById(userId).orElseThrow( () -> ResourceNotFoundException
//                .builder()
//                .resourceName("User")
//                .fieldName(" id")
//                .fieldValue(userId)
//                .build());
//        this.userRepo.delete(user);
    }

//    Convert Data from User Model to UserDto
    public UserDto userToDto(User user) {
        UserDto userDto= this.modelMapper.map(user , UserDto.class);
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
//        userDto.setAbout(user.getAbout());
//        userDto.setPassword(user.getPassword());
        return userDto;
    }


}
