package com.ecommerce.project.service.impl;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private List<Category> categories = new ArrayList<>();

    private Long idCounter = 1L;

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {

        category.setCategoryId(idCounter++);
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {

        Category category = categories.stream()
                .filter(cat -> cat.getCategoryId().equals(categoryId))
                .findFirst().orElse(null);

        if (category == null) {
            return "Category with categoryId " + categoryId + " not found";
        }

        categories.remove(category);

        return "Category with categoryId " + categoryId + " deleted Successfully";
    }
}
