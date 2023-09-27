package com.airlines.booking.repo;


import com.airlines.booking.models.User;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import java.util.Optional;

//@Repository
public interface UserRepo extends MongoRepository<User, String> {
//    public UserRepo(MongoEntityInformation<User, String> metadata, MongoOperations mongoOperations) {
//        super(metadata, mongoOperations);
//    }
    User findByEmail(String email);
    boolean existsByEmail(String email);
}
