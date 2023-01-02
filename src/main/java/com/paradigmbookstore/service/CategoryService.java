package com.paradigmbookstore.service;

import com.paradigmbookstore.model.Category;
import com.paradigmbookstore.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category loadCategory(Long id){
        return categoryRepository.findById(id).orElseThrow();
    }

    public Category findByName(String value) {
      return categoryRepository.findByName(value);
    }
}
