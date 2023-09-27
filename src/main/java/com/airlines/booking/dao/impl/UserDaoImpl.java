package com.airlines.booking.dao.impl;

import com.airlines.booking.dao.UserDao;
import com.airlines.booking.exceptions.DatabaseException;
import com.airlines.booking.exceptions.NotFoundException;
import com.airlines.booking.exceptions.ResourceAlreadyExists;
import com.airlines.booking.models.User;
import com.airlines.booking.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

import static com.airlines.booking.contants.DbConstants.USER_COLLECTION;

@AllArgsConstructor
public class UserDaoImpl implements UserDao {
    UserRepo userRepo;

    @Override
    public User createUser(User user) {
        if(this.userRepo.existsByEmail(user.getEmail())) {
            throw new ResourceAlreadyExists(String.format("User with emailId: %s is registered with us!", user.getEmail()));
        }
        try {
            return this.userRepo.save(user);
        } catch (Exception e) {
            throw new DatabaseException(String.format("[CREATE_USER] Exception while inserting the entry in the Database! with Message: %s", e.getMessage()), e);
        }
    }

    @Override
    public User getUserDetails(String email) {
        if(!this.userRepo.existsByEmail(email)) {
            throw new NotFoundException(String.format("User with emailId: %s does not exists in our database!", email));
        }
        try {
            return this.userRepo.findByEmail(email);
        } catch (Exception e) {
            throw new DatabaseException(String.format("[GET_USER] Exception while Querying the Database! with Message: %s", e.getMessage()), e);
        }
    }

    @Override
    public List<User> getAllUserDetails() {
        try {
            return this.userRepo.findAll();
        } catch (Exception e) {
            throw new DatabaseException(String.format("[GET_ALL_USERS] Exception while entering the Database! with Message: %s", e.getMessage()), e);
        }
    }

    @Override
    public User updateUserDetails(User user) {
        return User.builder().build();
    }

    @Override
    public boolean deleteUser(String email, String password) {
        return false;
    }
}
