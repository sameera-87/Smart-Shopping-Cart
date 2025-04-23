package com.Sameera.smart_shopping.repository;

import com.Sameera.smart_shopping.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findByProductId(Long productID);
}
