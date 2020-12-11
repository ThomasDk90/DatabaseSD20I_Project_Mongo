package com.dbproject.repositories;

import com.dbproject.entities.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Location,String> {
}
