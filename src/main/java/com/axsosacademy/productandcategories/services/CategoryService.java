package com.axsosacademy.productandcategories.services;

import com.axsosacademy.productandcategories.models.Category;
import com.axsosacademy.productandcategories.models.Product;
import com.axsosacademy.productandcategories.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Create New Category
    public void addNewCategory(Category category) {
        categoryRepository.save(category);
    }

    // Get All Categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Get Product by ID
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    // Add a Product to a Category
    public void addProductToCategory(Product product, Long categoryId) {
        Category category = getCategoryById(categoryId);
        if (category != null) {
            if (!category.getProducts().contains(product)) {
                category.getProducts().add(product);
                categoryRepository.save(category);
            }
        }
    }

    public List<Category> getUnassignedCategories(Product product) {
        return categoryRepository.findByProductsNotContains(product);
    }
}
