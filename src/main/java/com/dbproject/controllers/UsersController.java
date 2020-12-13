package com.dbproject.controllers;

import com.dbproject.model.*;

import com.dbproject.repositories.LocationRepository;
import com.dbproject.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    LocationRepository locationRepository;

    @GetMapping("/user/showAll")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = new ArrayList<>();
            users.addAll(usersRepository.findAll());
            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/user/saveUser")
    public ResponseEntity<User> createUser(@RequestBody User user, @Param("locationID") String locationID) {

      try {
          Location location = locationRepository.findById(locationID).get();
          user.setLocation(location);
            User userSaved = usersRepository.save(user);
            return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/user/del")
    public ResponseEntity<User> delUser(@RequestBody User user, @Param("uID") String uID) {

        try {
            User tempUser = usersRepository.findById(uID).get();
            usersRepository.delete(tempUser);
            return new ResponseEntity<>(tempUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/user/login")
    public String userLogIn(@Param("user_name") String user_name, @Param("password") String password){
        try{
            User tempUser = usersRepository.findByUserName(user_name);
            String savedPass = tempUser.getPassword();
            String paramPass = password;

                if (savedPass.equals(paramPass)){
                    return "Credentials OK";
                }
                else{
                    return "Wrong credentials";
                }
        }
        catch (NullPointerException e) {
                return "Wrong credentials";
        }
    }
}
