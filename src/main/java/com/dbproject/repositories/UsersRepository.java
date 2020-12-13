package com.dbproject.repositories;

import com.dbproject.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UsersRepository extends MongoRepository<User, String> {

    @Query("{'user_name': ?0}")
    User findByUserName(String userName); //defines a list of Users with the same name*/
}
