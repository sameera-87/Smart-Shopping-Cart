package com.Sameera.smart_shopping.repository;

import com.Sameera.smart_shopping.model.Category;
import com.Sameera.smart_shopping.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
