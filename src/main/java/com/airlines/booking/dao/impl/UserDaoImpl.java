package com.airlines.booking.dao.impl;

import com.airlines.booking.dao.UserDao;
import com.airlines.booking.exceptions.DatabaseException;
import com.airlines.booking.models.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

import static com.airlines.booking.contants.DbConstants.USER_COLLECTION;

@AllArgsConstructor
public class UserDaoImpl implements UserDao {
    MongoTemplate mongoTemplate;

    @Override
    public User createUser(User user) {
        try {

            return mongoTemplate.insert(user, USER_COLLECTION);
        } catch (Exception e) {
            throw new DatabaseException(String.format("[CREATE_USER] Exception while inserting the entry in the Database! with Message: %s", e.getMessage()), e);
        }
    }

    @Override
    public User getUserDetails(String email) {
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("email").is(email));
            return mongoTemplate.findOne(query, User.class, USER_COLLECTION);
        } catch (Exception e) {
            throw new DatabaseException(String.format("[CREATE_USER] Exception while Querying the Database! with Message: %s", e.getMessage()), e);
        }
    }

    @Override
    public List<User> getAllUserDetails() {
        try {
            return mongoTemplate.findAll(User.class, USER_COLLECTION);
        } catch (Exception e) {
            throw new DatabaseException(String.format("[GET_ALL_USERS] Exception while entering the Database! with Message: %s", e.getMessage()), e);
        }
    }

    @Override
    public User updateUserDetails(User user) {
        return new User();
    }

    @Override
    public boolean deleteUser(String email, String password) {
        return false;
    }
}
