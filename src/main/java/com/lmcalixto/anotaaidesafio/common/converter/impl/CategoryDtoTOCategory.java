package com.lmcalixto.anotaaidesafio.common.converter.impl;

import com.lmcalixto.anotaaidesafio.common.converter.GenericConverter;
import com.lmcalixto.anotaaidesafio.model.domain.Category;
import com.lmcalixto.anotaaidesafio.infrastructure.adapter.in.domain.CategoryDTO;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoTOCategory implements GenericConverter<CategoryDTO, Category> {
    @Override
    public Category toDestination(CategoryDTO source) {
        return Category.builder().title(source.title()).description(source.description()).ownerId(source.ownerId()).build();
    }
}
