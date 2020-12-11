package com.dbproject.repositories;

import com.dbproject.entities.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsersRepository extends MongoRepository<Users, String> {

    /*@Query("SELECT u FROM  Users u WHERE u.userName = :username")
    Users findByUserName(@Param("username") String userName); //defines a list of Users with the same name*/
}
