package com.Sameera.smart_shopping.service.category;

import com.Sameera.smart_shopping.model.Category;

import java.util.List;

public interface ICategoryService {
    Category getCategoryById(Long id);
    Category getCategoryByName(String name);
    List<Category> getAllCategories();
    Category addCategory(Category category);
    Category updategCategory(Category category, Long id);
    void deleteCategoryById(Long id);
}
