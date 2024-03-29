package com.dbproject.controllers;

import com.dbproject.model.*;
import com.dbproject.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/vehicle/showAll")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        try {
            List<Vehicle> vehicles = new ArrayList<>();
            vehicles.addAll(vehiclesRepository.findAll());
            if (vehicles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/vehicle/show")
    public ResponseEntity<Vehicle> showVehicleByID(@RequestParam("vehicleID") String vehicleID){

        try {
            Vehicle vehicle = vehiclesRepository.findById(vehicleID).get();
            return new ResponseEntity<>(vehicle, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/vehicle/del")
    public void deleteVehicle(@RequestParam("vehicleID") String vehicleID){
        Vehicle vehicle = vehiclesRepository.findById(vehicleID).get();
        try{
            vehiclesRepository.delete(vehicle);
        }
        catch (Exception e) {
            new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/vehicle/save", method = RequestMethod.POST)
    public ResponseEntity<Vehicle> saveVehicle(@RequestParam("locationID") String locationID,
                                                 @RequestParam("uID") String uID,
                                                 @RequestParam("makeID") String makeID,
                                                 @RequestParam("modelID") String modelID,
                                                 @RequestBody Vehicle vehicle ) {
        try {
            User user = usersRepository.findById(uID).get();
            Location location = locationRepository.findById(locationID).get();
            Model model = modelRepository.findById(modelID).get();
            Make make = makeRepository.findById(makeID).get();

            vehicle.setUser(user);
            vehicle.setLocation(location);
            vehicle.setMake(make);
            vehicle.setModel(model);

            Vehicle vehicleSaved = vehiclesRepository.save(vehicle);
            return new ResponseEntity<>(vehicleSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
