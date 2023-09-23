package com.airlines.booking.dao;

import com.airlines.booking.exceptions.DatabaseException;
import com.airlines.booking.models.User;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


public interface UserDao {
    public User createUser(User user);
    public User getUserDetails(String email);
    public User updateUserDetails(User user);
    public boolean deleteUser(String email, String password);
}
