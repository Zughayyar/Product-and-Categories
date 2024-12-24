package com.axsosacademy.productandcategories.repositories;


import com.axsosacademy.productandcategories.models.Category;
import com.axsosacademy.productandcategories.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();

    // Retrieves all categories assigned to a specific product
    List<Category> findAllByProducts(Product product);

    // Retrieves all categories NOT assigned to a specific product
    List<Category> findByProductsNotContains(Product product);
}
