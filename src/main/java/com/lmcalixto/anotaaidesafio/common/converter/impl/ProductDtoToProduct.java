package com.lmcalixto.anotaaidesafio.common.converter.impl;

import com.lmcalixto.anotaaidesafio.common.converter.GenericConverter;
import com.lmcalixto.anotaaidesafio.infrastructure.adapter.in.domain.ProductDTO;
import com.lmcalixto.anotaaidesafio.model.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoToProduct implements GenericConverter<ProductDTO, Product> {
    @Override
    public Product toDestination(ProductDTO source) {
        return Product.builder().title(source.title()).description(source.description()).ownerId(source.ownerId()).price(source.price()).category(source.category()).build();
    }
}
