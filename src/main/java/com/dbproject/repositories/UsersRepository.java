package com.dbproject.repositories;

import com.dbproject.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<User, String> {

    /*@Query("SELECT u FROM  Users u WHERE u.userName = :username")
    Users findByUserName(@Param("username") String userName); //defines a list of Users with the same name*/
}
