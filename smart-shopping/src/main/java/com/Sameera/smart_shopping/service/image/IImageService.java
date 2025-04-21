package com.Sameera.smart_shopping.service.image;

import com.Sameera.smart_shopping.model.Image;
import org.springframework.web.multipart.MultipartFile;

public interface IImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    Image saveImage(MultipartFile file, Long productId);
    Image updateImage(MultipartFile file, Long imageId);


}
