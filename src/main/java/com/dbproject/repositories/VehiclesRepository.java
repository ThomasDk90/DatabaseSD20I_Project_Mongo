package com.dbproject.repositories;

import com.dbproject.entities.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehiclesRepository extends MongoRepository<Vehicle, String> {


}
