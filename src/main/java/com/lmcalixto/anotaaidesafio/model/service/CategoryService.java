package com.lmcalixto.anotaaidesafio.model.service;

import com.lmcalixto.anotaaidesafio.common.converter.impl.CategoryDtoTOCategory;
import com.lmcalixto.anotaaidesafio.common.exception.CategoryNotExistException;
import com.lmcalixto.anotaaidesafio.model.domain.Category;
import com.lmcalixto.anotaaidesafio.infrastructure.adapter.in.domain.CategoryDTO;
import com.lmcalixto.anotaaidesafio.model.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    private final CategoryDtoTOCategory converter;

    public CategoryService (CategoryRepository repository, CategoryDtoTOCategory converter){
        this.repository = repository;
        this.converter = converter;
    }

    public Category insertCategory (CategoryDTO categoryDTO){
        return repository.save(converter.toDestination(categoryDTO));
    }

    public List<Category> listAll (){
        return repository.findAll();
    }

    public Category update(String id, CategoryDTO categoryDTO) {
        Category existCategory = repository.findById(id).orElseThrow(() -> new CategoryNotExistException("Categoria inexistente!!!"));

        if(!categoryDTO.title().isEmpty()) existCategory.setTitle(categoryDTO.title());
        if(!categoryDTO.description().isEmpty()) existCategory.setDescription(categoryDTO.description());

        return repository.save(existCategory);
    }

    public void delete(String id) {
        Category existCategory = repository.findById(id).orElseThrow(() -> new CategoryNotExistException("Categoria inexistente!!!"));
        repository.delete(existCategory);
    }
}
