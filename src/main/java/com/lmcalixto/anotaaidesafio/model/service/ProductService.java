package com.lmcalixto.anotaaidesafio.model.service;

import com.lmcalixto.anotaaidesafio.model.domain.Product;
import com.lmcalixto.anotaaidesafio.model.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

}
