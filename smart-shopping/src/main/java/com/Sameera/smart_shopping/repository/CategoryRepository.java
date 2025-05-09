package com.Sameera.smart_shopping.repository;

import com.Sameera.smart_shopping.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);

    boolean existsByName(String name);
}
