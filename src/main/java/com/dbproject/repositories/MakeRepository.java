package com.dbproject.repositories;

import com.dbproject.model.Make;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MakeRepository extends MongoRepository<Make, String> {
}
