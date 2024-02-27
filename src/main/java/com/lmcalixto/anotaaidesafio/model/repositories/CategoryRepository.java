package com.lmcalixto.anotaaidesafio.model.repositories;

import com.lmcalixto.anotaaidesafio.model.domain.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
