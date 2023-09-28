package com.airlines.booking.controllers;


import com.airlines.booking.payloads.ApiResponse;
import com.airlines.booking.payloads.UserDto;
import com.airlines.booking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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
    @Value("${spring.db.name}")
    private String DB_NAME;
    @Autowired
    Environment environment;
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<ApiResponse> createUser(@RequestBody UserDto userDto) {
        System.out.println(userDto.toString());
        ApiResponse createUserDto = this.userService.createUser(userDto);
        System.out.println("[TESTING DOT_ENV]" + environment.getProperty("JAVA_HOME"));
        System.out.println("[TESTING SYS PROPERTY]" + environment.getProperty("spring.data.mongodb.uri"));
        System.out.println("[TESTING DOT_ENV MONGODB_URL]" + environment.getProperty("MONGODB_URL"));
        System.out.println("[TESTING DOT_ENV DB_NAME]" + environment.getProperty("DB_NAME"));
        System.out.println("[RESPONSE CONTROLLER]: " + createUserDto.toString());
        System.out.println("[DbConfigurationModule] DB_NAME: " + System.getProperty("DB_NAME"));
        return new ResponseEntity<ApiResponse>(createUserDto, HttpStatus.CREATED);
    }
    @PutMapping("/{email}")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody UserDto user,  @PathVariable("email") String email) {
        ApiResponse updatedUser = this.userService.updateUser(user, email);
        System.out.println(updatedUser.toString());
        return new ResponseEntity<ApiResponse>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<ApiResponse> deleteUser(@RequestBody UserDto user, @PathVariable("email") String email) {
        ApiResponse apiResponse = this.userService.deleteUser(user, email);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<ApiResponse> getUser(@PathVariable("email") String email) {
        ApiResponse userDto = this.userService.getUserById(email);
        return new ResponseEntity<>(userDto , HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAllUsers() {
        ApiResponse usersDto = this.userService.getAllUser();
        return new ResponseEntity<ApiResponse>(usersDto,HttpStatus.OK);
    }




}
