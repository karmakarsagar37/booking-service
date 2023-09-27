package com.airlines.booking.dao.impl;

import com.airlines.booking.dao.UserDao;
import com.airlines.booking.exceptions.DatabaseException;
import com.airlines.booking.exceptions.NonRetryableException;
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
    public User updateUserDetails(User user, String email) {
        if(!this.userRepo.existsByEmail(user.getEmail())) {
            throw new NotFoundException(String.format("User with emailId: %s does not exists in our database!", user.getEmail()));
        }
        User existingUser = this.userRepo.findByEmail(email);
        if(!user.getPassword().equals(existingUser.getPassword())) {
            throw new NonRetryableException(String.format("You cannot update the password through this API use the Reset Password API!",email));
        }
        existingUser.setAbout(user.getAbout());
        existingUser.setName(user.getName());
        try {
            System.out.println(this.userRepo.deleteByEmail(email));
            System.out.println("[TO BE SAVED]" + existingUser);
            return this.userRepo.save(existingUser);
        } catch (Exception e) {
            throw new DatabaseException(String.format("[UPDATE_USER] Exception while entering the Database! with Message: %s", e.getMessage()), e);
        }
    }

    @Override
    public boolean deleteUser(User user, String email) {
        if(!this.userRepo.existsByEmail(email)) {
            throw new NotFoundException(String.format("User with emailId: %s does not exists in our database. Cannot delete non-existing entities it!", email));
        }
        //Check whether the password provided is same
        User existingUser = this.userRepo.findByEmail(email);
        if(!user.getPassword().equals(existingUser.getPassword())) {
            throw new NonRetryableException(String.format("Password provided for the email: %s is incorrect. Pleas try again with the correct password!",email));
        }
        try {
            Long res = this.userRepo.deleteByEmail(email);
            System.out.println(res);
            return res == 1;
        } catch (Exception e) {
            throw new DatabaseException(String.format("[UPDATE_USER] Exception while entering the Database! with Message: %s", e.getMessage()), e);
        }
    }
}
