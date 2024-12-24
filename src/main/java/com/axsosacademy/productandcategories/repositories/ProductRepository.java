package com.axsosacademy.productandcategories.repositories;


import com.axsosacademy.productandcategories.models.Category;
import com.axsosacademy.productandcategories.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();

    // Retrieves all products assigned to a specific category
    List<Product> findAllByCategories(Category category);

    // Retrieves all categories NOT assigned to a specific product
    List<Product> findByCategoriesNotContains(Category category);
}
