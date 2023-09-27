package com.airlines.booking.dao;

import com.airlines.booking.models.User;

import java.util.List;

public interface UserDao {
    public User createUser(User user);
    public User getUserDetails(String email);
    public List<User> getAllUserDetails();
    public User updateUserDetails(User user, String email);
    public boolean deleteUser(User user, String email);
}
