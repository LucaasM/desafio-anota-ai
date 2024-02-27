package com.lmcalixto.anotaaidesafio.model.repositories;

import com.lmcalixto.anotaaidesafio.model.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
