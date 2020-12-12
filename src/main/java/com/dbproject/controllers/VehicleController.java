package com.dbproject.controllers;

import com.dbproject.model.User;
import com.dbproject.model.Vehicle;
import com.dbproject.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class VehicleController {
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    ModelRepository modelRepository;

    @Autowired
    VehiclesRepository vehiclesRepository;
    @Autowired
    MakeRepository makeRepository;


/*    public VehicleController(UsersRepository usersRepository, VehiclesRepository vehiclesRepository, LocationRepository locationRepository, ModelRepository modelRepository, MakeRepository makeRepository) {
        this.usersRepository = usersRepository;
        this.vehiclesRepository = vehiclesRepository;
        this.locationRepository = locationRepository;
        this.modelRepository = modelRepository;
        this.makeRepository = makeRepository;
    }*/

    @GetMapping("/vehicle")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        try {
            List<Vehicle> vehicles = new ArrayList<>();
            vehicles.addAll(vehiclesRepository.findAll());
            if (vehicles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/vehicle")
    public ResponseEntity<Vehicle> createUser(@RequestBody Vehicle vehicle) {
      try {
          Vehicle vehicleSaved = vehiclesRepository.save(vehicle);
            return new ResponseEntity<>(vehicleSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
