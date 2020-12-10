package com.dbproject.repositories;

import com.dbproject.entities.Model;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ModelRepository extends MongoRepository<Model, String> {
}
