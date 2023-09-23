package com.airlines.booking.controllers;


import com.airlines.booking.payloads.ApiResponse;
import com.airlines.booking.payloads.UserDto;
import com.airlines.booking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<ApiResponse> createUser(@RequestBody UserDto userDto) {
        System.out.println(userDto.toString());
        ApiResponse createUserDto = this.userService.createUser(userDto);
        System.out.println("[RESPONSE CONTROLLER]: " + createUserDto.toString());
        return new ResponseEntity<ApiResponse>(createUserDto, HttpStatus.CREATED);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody UserDto user,@PathVariable("userId") Integer userId) {
        System.out.println(user.toString());
        ApiResponse updatedUser = this.userService.updateUser(user,userId);
        System.out.println(updatedUser.toString());
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@RequestBody UserDto user, @PathVariable("userId") Integer userId) {
        this.userService.deleteUser(userId);
        return new ResponseEntity<ApiResponse>(ApiResponse.builder()
                .success(true)
//                .message("User Deleted Successfully")
                .build(),
                HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse> getUser(@RequestBody UserDto user,@PathVariable("userId") Integer userId) {
        ApiResponse userDto = this.userService.getUserById(userId);
        return new ResponseEntity<>(userDto , HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAllUsers() {
        ApiResponse usersDto = this.userService.getAllUser();
        return new ResponseEntity<>(usersDto,HttpStatus.OK);
    }




}
