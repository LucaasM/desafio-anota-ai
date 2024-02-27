package com.lmcalixto.anotaaidesafio.infrastructure.adapter.in.domain;

import com.lmcalixto.anotaaidesafio.model.domain.Category;

public record ProductDTO(String title, String description, String ownerId, Integer price, Category category) {
}
