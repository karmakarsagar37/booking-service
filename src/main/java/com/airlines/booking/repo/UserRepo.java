package com.airlines.booking.repo;

import com.airlines.booking.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {
    User findByEmail(String email);
    boolean existsByEmail(String email);
    Long deleteByEmail(String email);
}
