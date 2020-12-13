package com.dbproject.repositories;

import com.dbproject.model.PaymentType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentTypeRepository extends MongoRepository<PaymentType, String> {
}
