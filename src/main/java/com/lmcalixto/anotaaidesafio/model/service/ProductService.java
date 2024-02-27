package com.lmcalixto.anotaaidesafio.model.service;

import com.lmcalixto.anotaaidesafio.common.converter.impl.CategoryDtoTOCategory;
import com.lmcalixto.anotaaidesafio.common.converter.impl.ProductDtoToProduct;
import com.lmcalixto.anotaaidesafio.common.exception.CategoryNotExistException;
import com.lmcalixto.anotaaidesafio.common.exception.ProductNotExistException;
import com.lmcalixto.anotaaidesafio.infrastructure.adapter.in.domain.CategoryDTO;
import com.lmcalixto.anotaaidesafio.infrastructure.adapter.in.domain.ProductDTO;
import com.lmcalixto.anotaaidesafio.model.domain.Category;
import com.lmcalixto.anotaaidesafio.model.domain.Product;
import com.lmcalixto.anotaaidesafio.model.repositories.CategoryRepository;
import com.lmcalixto.anotaaidesafio.model.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final CategoryService service;

    private final ProductRepository repository;

    private final ProductDtoToProduct converter;

    public ProductService (ProductRepository repository, ProductDtoToProduct converter, CategoryService service){
        this.repository = repository;
        this.service = service;
        this.converter = converter;
    }

    public Product insertProduct (ProductDTO productDTO){
        service.getCategory(productDTO.category().getId()).orElseThrow(() -> new CategoryNotExistException("Categoria inexistente!!!"));

        return repository.save(converter.toDestination(productDTO));
    }

    public List<Product> listAll (){
        return repository.findAll();
    }

    public Product update(String id, ProductDTO productDTO) {
        Product existProduct = repository.findById(id).orElseThrow(() -> new ProductNotExistException("Produto inexistente!!!"));

        if(!productDTO.title().isEmpty()) existProduct.setTitle(productDTO.title());
        if(!productDTO.description().isEmpty()) existProduct.setDescription(productDTO.description());
        if(productDTO.price() != null) existProduct.setPrice(productDTO.price());

        Category category = service.getCategory(productDTO.category().getId()).orElseThrow(() -> new CategoryNotExistException("Categoria inexistente!!!"));

        if(category != null) {
           existProduct.setCategory(productDTO.category());
        }

        return repository.save(existProduct);
    }

    public void delete(String id) {
        Product existCategory = repository.findById(id).orElseThrow(() -> new ProductNotExistException("Produto inexistente!!!"));
        repository.delete(existCategory);
    }

}
