package com.lmcalixto.anotaaidesafio.infrastructure.adapter.in.controllers;

import com.lmcalixto.anotaaidesafio.infrastructure.adapter.in.domain.CategoryDTO;
import com.lmcalixto.anotaaidesafio.model.service.CategoryService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<?> create (@RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insertCategory(categoryDTO));
    }

    @GetMapping()
    public ResponseEntity<?> listAll(){
        return ResponseEntity.ok().body(service.listAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody  CategoryDTO categoryDTO) {
        return ResponseEntity.ok().body(service.update(id, categoryDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
